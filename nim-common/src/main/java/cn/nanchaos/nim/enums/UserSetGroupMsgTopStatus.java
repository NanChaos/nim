package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Default Description
 * 用户设置群组消息置顶状态
 * 0：默认值，不置顶
 * 1：置顶
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 17:05
 */
@Getter
@AllArgsConstructor
public enum UserSetGroupMsgTopStatus {
    /**
     * 消息不置顶
     */
    USER_SET_GROUP_MSG_TOP_OFF("USER_SET_GROUP_MSG_TOP_OFF", "0", "消息不置顶"),

    /**
     * 消息置顶
     */
    USER_SET_GROUP_MSG_TOP_ON("USER_SET_GROUP_MSG_TOP_ON", "1", "消息置顶");

    private String code;
    private String status;
    private String msg;
}
