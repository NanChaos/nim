package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Default Description
 * 消息类型
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 15:56
 */
@Getter
@AllArgsConstructor
public enum MsgTypeEnum {
    /**
     * 文本类型消息
     */
    MSG_TYPE_TEXT("MSG_TYPE_TEXT", "文本类型消息"),

    /**
     * 图片类型消息
     */
    MSG_TYPE_IMG("MSG_TYPE_IMG", "图片类型消息"),

    /**
     * 地址位置类型消息
     */
    MSG_TYPE_LOCATION("MSG_TYPE_LOCATION", "地址位置类型消息"),

    /**
     * 语音类型消息
     */
    MSG_TYPE_AUDIO("MSG_TYPE_AUDIO", "语音类型消息"),

    /**
     * 视频类型消息
     */
    MSG_TYPE_VIDEO("MSG_TYPE_VIDEO", "视频类型消息"),

    /**
     * 文件类型消息
     */
    MSG_TYPE_FILE("MSG_TYPE_FILE", "文件类型消息");

    private String code;
    private String msg;
}
