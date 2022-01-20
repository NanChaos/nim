package cn.nanchaos.nim.model.msg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Default Description
 * MongoDB  消息
 *
 * @author: nanchaos
 * @date: 2022/1/13
 * @time: 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message implements Serializable {

    /**
     * ObjectId作为messageId
     */
    @Id
    private String msgId;

    /**
     * 消息体
     */
    private String msgBody;


    /**
     * 消息类型 详见MsgTypeEnum
     */
    private String msgType;


    /**
     * 发送人ID,消息一定是某一个人发的
     */
    private Integer senderUid;


    /**
     * 接收ID，但是消息可能是发给某一个人，也可能是发送到某一个群组 or 聊天室
     * - USER_ID
     * - GROUP_ID
     * - ROOM_ID
     */
    private Integer receiverId;

    /**
     * 接受者类型
     * - USER
     * - GROUP
     * - ROOM
     */
    private String receiverType;

    /**
     * 聊天类型：ChatTypeEnum
     * - CHAT_TYPE_HUMANKIND，单聊
     * - CHAT_TYPE_GROUP，群聊
     * - CHAT_TYPE_ROOM，聊天室
     */
    private String chatType;

    /**
     * 消息发送时间
     */
    private Date timestamp;
}
