package cn.nanchaos.nim.util;

import cn.nanchaos.nim.processor.OnlineProcessor;
import io.netty.channel.Channel;

import java.net.SocketAddress;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 10:12
 */
public class ServerToolUtil {
    public static String clientInfoToString(Channel session) {
        SocketAddress remoteAddress = session.remoteAddress();
        String s1 = remoteAddress.toString();
        StringBuilder sb = (new StringBuilder()).append("{uid:").append(OnlineProcessor.getUserIdFromChannel(session)).append("}").append(s1);
        return sb.toString();
    }
}
