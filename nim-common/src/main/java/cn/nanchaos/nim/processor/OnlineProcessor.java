package cn.nanchaos.nim.processor;

import cn.nanchaos.nim.Gateway;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 10:13
 */
public class OnlineProcessor {
    public static final AttributeKey<String> ATTRIBUTE_KEY_USER_ID = AttributeKey.newInstance("__user_id__");
    public static final AttributeKey<Long> ATTRIBUTE_KEY_FIRST_LOGIN_TIME = AttributeKey.newInstance("__first_login_time__");
    public static final AttributeKey<Integer> ATTRIBUTE_KEY_BE_KICKOUT_CODE = AttributeKey.newInstance("__be_keickout_code__");
    public static boolean DEBUG = false;
    private static Logger logger = LoggerFactory.getLogger(OnlineProcessor.class);
    private static volatile OnlineProcessor instance = null;
    private ConcurrentMap<String, Channel> onlineSessions = new ConcurrentHashMap();

    public static OnlineProcessor getInstance() {
        if (instance == null) {
            Class var0 = OnlineProcessor.class;
            synchronized (OnlineProcessor.class) {
                if (instance == null) {
                    instance = new OnlineProcessor();
                }
            }
        }

        return instance;
    }

    private OnlineProcessor() {
    }

    public boolean putUser(String user_id, long firstLoginTime, Channel newSession) {
        boolean putOk = true;
        Channel oldSession = (Channel) this.onlineSessions.get(user_id);
        if (oldSession != null) {
            boolean isTheSame = oldSession.compareTo(newSession) == 0;
            logger.debug("[IMCORE-{}]【注意】用户id={}已经在在线列表中了，session也是同一个吗？{}", new Object[]{Gateway.$(newSession), user_id, isTheSame});
            if (!isTheSame) {
                if (firstLoginTime <= 0L) {
                    logger.debug("[IMCORE-{}]【注意】用户id={}提交过来的firstLoginTime未设置(值={}, 应该是真的首次登陆？！)，将无条件踢出前面的会话！", new Object[]{Gateway.$(newSession), user_id, firstLoginTime});
                    // this.sendKickoutDuplicateLogin(oldSession, user_id);
                    this.onlineSessions.put(user_id, newSession);
                } else {
                    long firstLoginTimeForOld = getFirstLoginTimeFromChannel(oldSession);
                    if (firstLoginTime >= firstLoginTimeForOld) {
                        logger.debug("[IMCORE-{}]【提示】用户id={}提交过来的firstLoginTime为{}、firstLoginTimeForOld为{}，新的“首次登陆时间”【晚于】列表中的“老的”、正常踢出老的即可！", new Object[]{Gateway.$(newSession), user_id, firstLoginTime, firstLoginTimeForOld});
                        // this.sendKickoutDuplicateLogin(oldSession, user_id);
                        this.onlineSessions.put(user_id, newSession);
                    } else {
                        logger.debug("[IMCORE-{}]【注意】用户id={}提交过来的firstLoginTime为{}、firstLoginTimeForOld为{}，新的“首次登陆时间”【早于】列表中的“老的”，表示“新”的会话应该是未被正常通知的“已踢”会话，应再次向“新”会话发出被踢通知！！", new Object[]{Gateway.$(newSession), user_id, firstLoginTime, firstLoginTimeForOld});
                        // this.sendKickoutDuplicateLogin(newSession, user_id);
                        putOk = false;
                    }
                }
            } else {
                this.onlineSessions.put(user_id, newSession);
            }
        } else {
            this.onlineSessions.put(user_id, newSession);
        }

        this.__printOnline();
        return putOk;
    }

    public void __printOnline() {
        logger.debug("【@】当前在线用户共(" + this.onlineSessions.size() + ")人------------------->");
        if (DEBUG) {
            Iterator var2 = this.onlineSessions.keySet().iterator();

            while (var2.hasNext()) {
                String key = (String) var2.next();
                logger.debug("      > user_id=" + key + ",session=" + ((Channel) this.onlineSessions.get(key)).remoteAddress());
            }
        }

    }

    public boolean removeUser(String user_id) {
        synchronized (this.onlineSessions) {
            if (!this.onlineSessions.containsKey(user_id)) {
                logger.warn("[IMCORE]！用户id={}不存在在线列表中，本次removeUser没有继续.", user_id);
                this.__printOnline();
                return false;
            } else {
                return this.onlineSessions.remove(user_id) != null;
            }
        }
    }

    public Channel getOnlineSession(String user_id) {
        if (user_id == null) {
            logger.warn("[IMCORE][CAUTION] getOnlineSession时，作为key的user_id== null.");
            return null;
        } else {
            return (Channel) this.onlineSessions.get(user_id);
        }
    }

    public ConcurrentMap<String, Channel> getOnlineSessions() {
        return this.onlineSessions;
    }

    public static boolean isLogined(Channel session) {
        return session != null && getUserIdFromChannel(session) != null;
    }

    public static boolean isOnline(String userId) {
        return getInstance().getOnlineSession(userId) != null;
    }

    public static void setUserIdForChannel(Channel session, String userId) {
        session.attr(ATTRIBUTE_KEY_USER_ID).set(userId);
    }

    public static void setFirstLoginTimeForChannel(Channel session, long firstLoginTime) {
        session.attr(ATTRIBUTE_KEY_FIRST_LOGIN_TIME).set(firstLoginTime);
    }

    public static void setBeKickoutCodeForChannel(Channel session, int beKickoutCode) {
        session.attr(ATTRIBUTE_KEY_BE_KICKOUT_CODE).set(beKickoutCode);
    }

    public static String getUserIdFromChannel(Channel session) {
        return session != null ? (String) session.attr(ATTRIBUTE_KEY_USER_ID).get() : null;
    }

    public static long getFirstLoginTimeFromChannel(Channel session) {
        if (session != null) {
            Long attr = (Long) session.attr(ATTRIBUTE_KEY_FIRST_LOGIN_TIME).get();
            return attr != null ? attr : -1L;
        } else {
            return -1L;
        }
    }

    public static int getBeKickoutCodeFromChannel(Channel session) {
        if (session != null) {
            Integer attr = (Integer) session.attr(ATTRIBUTE_KEY_BE_KICKOUT_CODE).get();
            return attr != null ? attr : -1;
        } else {
            return -1;
        }
    }

    public static void removeAttributesForChannel(Channel session) {
        session.attr(ATTRIBUTE_KEY_USER_ID).set((String) null);
        session.attr(ATTRIBUTE_KEY_FIRST_LOGIN_TIME).set((Long) null);
        session.attr(ATTRIBUTE_KEY_BE_KICKOUT_CODE).set((Integer) null);
    }
}
