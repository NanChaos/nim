package cn.nanchaos.nim;

import cn.nanchaos.nim.event.MessageQosEventListenerS2C;
import cn.nanchaos.nim.event.ServerEventListener;
import cn.nanchaos.nim.processor.BridgeProcessor;
import cn.nanchaos.nim.processor.LogicProcessor;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 10:15
 */
public class ServerCoreHandler {

    private ServerEventListener serverEventListener = null;
    private MessageQosEventListenerS2C serverMessageQoSEventListener = null;
    private LogicProcessor logicProcessor = null;
    private BridgeProcessor bridgeProcessor = null;
}
