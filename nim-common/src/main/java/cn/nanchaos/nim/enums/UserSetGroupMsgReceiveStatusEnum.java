package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Default Description
 * 群组消息接收状态：
 * - 0，接收并提醒
 * - 1，接收但不提醒
 * - 2，屏蔽群消息
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 16:56
 */
@Getter
@AllArgsConstructor
public enum UserSetGroupMsgReceiveStatusEnum {

    /**
     * 接收并提醒
     */
    USER_SET_GROUP_MSG_RECEIVE_AND_REMIND("USER_SET_GROUP_MSG_RECEIVE_AND_REMIND", "0", "接收并提醒"),

    /**
     *
     */
    USER_SET_GROUP_MSG_RECEIVE_BUT_NOT_REMIND("USER_SET_GROUP_MSG_RECEIVE_BUT_NOT_REMIND", "1", "接收但不提醒"),

    /**
     * 屏蔽群消息
     */
    USER_SET_GROUP_MSG_BLOCK("USER_SET_GROUP_MSG_BLOCK", "2", "");

    private String code;
    private String status;
    private String msg;
}
