package cn.nanchaos.nim.model.msg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Default Description
 * MongoDB交互的消息
 *
 * @author: nanchaos
 * @date: 2022/1/13
 * @time: 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MsgDO implements Serializable {
    private String msgId;
    private String msgBody;
    private String msgType;
    private Integer receiverUid;
    private Integer senderUid;
    private Date sendTime;
    private String msgReadStatus;
}
