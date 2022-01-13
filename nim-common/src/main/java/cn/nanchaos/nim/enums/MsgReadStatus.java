package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/13
 * @time: 17:07
 */
@Getter
@AllArgsConstructor
public enum MsgReadStatus {

    DELIVERED("DELIVERED", "已发送"),
    READ("READ", "已阅读");
    private String code;
    private String msg;
}
