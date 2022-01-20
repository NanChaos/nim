package cn.nanchaos.nim;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

public abstract class Gateway {
    public static final String SOCKET_TYPE_IN_CHANNEL_ATTRIBUTE = "__socket_type__";
    public static final AttributeKey<Integer> SOCKET_TYPE_IN_CHANNEL_ATTRIBUTE_ATTR = AttributeKey.newInstance("__socket_type__");
    public static final int SOCKET_TYPE_UDP = 1;
    public static final int SOCKET_TYPE_TCP = 2;
    public static final int SOCKET_TYPE_WEBSOCKET = 4;

    public Gateway() {
    }

    public abstract void init(ServerCoreHandler var1);

    public abstract void bind() throws Exception;

    public abstract void shutdown();

    public static void setSocketType(Channel c, int socketType) {
        c.attr(SOCKET_TYPE_IN_CHANNEL_ATTRIBUTE_ATTR).set(socketType);
    }

    public static void removeSocketType(Channel c) {
        c.attr(SOCKET_TYPE_IN_CHANNEL_ATTRIBUTE_ATTR).set((Integer) null);
    }

    public static int getSocketType(Channel c) {
        Integer socketType = (Integer) c.attr(SOCKET_TYPE_IN_CHANNEL_ATTRIBUTE_ATTR).get();
        return socketType != null ? socketType : -1;
    }

    public static boolean isSupportUDP(int support) {
        return (support & 1) == 1;
    }

    public static boolean isSupportTCP(int support) {
        return (support & 2) == 2;
    }

    public static boolean isSupportWebSocket(int support) {
        return (support & 4) == 4;
    }

    public static boolean isTCPChannel(Channel c) {
        return c != null && getSocketType(c) == 2;
    }

    public static boolean isUDPChannel(Channel c) {
        return c != null && getSocketType(c) == 1;
    }

    public static boolean isWebSocketChannel(Channel c) {
        return c != null && getSocketType(c) == 4;
    }

    public static String $(Channel c) {
        return getGatewayFlag(c);
    }

    public static String getGatewayFlag(Channel c) {
        if (isUDPChannel(c)) {
            return "udp";
        } else if (isTCPChannel(c)) {
            return "tcp";
        } else {
            return isWebSocketChannel(c) ? "websocket" : "unknow";
        }
    }
}
