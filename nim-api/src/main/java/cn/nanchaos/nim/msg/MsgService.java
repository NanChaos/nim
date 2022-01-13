package cn.nanchaos.nim.msg;

import cn.nanchaos.nim.response.Result;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/13
 * @time: 17:34
 */
public interface MsgService {
    /**
     * 发送消息
     *
     * @return
     */
    Result msgSend();

    /**
     * 接收消息
     *
     * @return
     */
    Result msgReceive();
}
