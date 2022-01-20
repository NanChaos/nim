package cn.nanchaos.nim.event;

import cn.nanchaos.nim.Protocol;
import io.netty.channel.Channel;

/**
 * Default Description
 * 服务器事件监听
 *
 * @author: nanchaos
 * @time: 2022/1/20
 */
public interface ServerEventListener {
    /**
     * onUserLoginVerify
     *
     * @param var1
     * @param var2
     * @param var3
     * @param var4
     * @return
     */
    int onUserLoginVerify(String var1, String var2, String var3, Channel var4);

    /**
     * onUserLoginSuccess
     *
     * @param var1
     * @param var2
     * @param var3
     */
    void onUserLoginSuccess(String var1, String var2, Channel var3);

    /**
     * onUserLogout
     *
     * @param var1
     * @param var2
     * @param var3
     */
    void onUserLogout(String var1, Channel var2, int var3);

    /**
     * onTransferMessage4C2S
     *
     * @param var1
     * @param var2
     * @return
     */
    boolean onTransferMessage4C2S(Protocol var1, Channel var2);

    /**
     * onTransferMessage4C2C
     *
     * @param var1
     */
    void onTransferMessage4C2C(Protocol var1);

    /**
     * onTransferMessage_RealTimeSendFailed
     *
     * @param var1
     * @return
     */
    boolean onTransferMessage_RealTimeSendFailed(Protocol var1);
}
