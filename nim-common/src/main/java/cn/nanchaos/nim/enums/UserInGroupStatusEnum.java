package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 16:49
 */
@Getter
@AllArgsConstructor
public enum UserInGroupStatusEnum {

    /**
     * 用户尚在群组中
     * 在，1
     */
    USER_IN_GROUP_STATUS_YET("USER_IN_GROUP_STATUS_YET", "1", "用户尚在群组中"),

    /**
     * 用户不在群组中
     * 不在，0
     */
    USER_IN_GROUP_STATUS_NOT("USER_IN_GROUP_STATUS_NOT", "0", "用户不在群组中");

    private String code;
    private String status;
    private String msg;
}
