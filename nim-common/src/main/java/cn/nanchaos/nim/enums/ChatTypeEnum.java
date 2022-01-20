package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Default Description
 * 聊天类型
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 15:40
 */
@Getter
@AllArgsConstructor
public enum ChatTypeEnum {
    /**
     * 好友单聊
     */
    CHAT_TYPE_HUMANKIND("CHAT_TYPE_HUMANKIND", "单聊"),

    /**
     * 群聊
     * 永久性，有owner
     */
    CHAT_TYPE_GROUP("CHAT_TYPE_GROUP", "群聊"),

    /**
     * 聊天室
     * 可以有任意用户发起，无owner
     */
    CHAT_TYPE_ROOM("CHAT_TYPE_ROOM", "聊天室");

    private String code;
    private String msg;
}
