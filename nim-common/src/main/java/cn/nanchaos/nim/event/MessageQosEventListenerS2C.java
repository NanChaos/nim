package cn.nanchaos.nim.event;

import cn.nanchaos.nim.Protocol;

import java.util.ArrayList;

/**
 * Default Description
 *
 * @author: nanchaos
 * @time: 2022/1/20
 */
public interface MessageQosEventListenerS2C {
    /**
     * messagesLost:消息丢失
     *
     * @param var1
     */
    void messagesLost(ArrayList<Protocol> var1);

    /**
     * messagesBeReceived:消息接收
     *
     * @param var1
     */
    void messagesBeReceived(String var1);
}
