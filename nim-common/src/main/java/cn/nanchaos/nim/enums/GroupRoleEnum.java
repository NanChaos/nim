package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Default Description
 *
 * @author: nanchaos
 * @time: 2022/1/20
 */
@Getter
@AllArgsConstructor
public enum GroupRoleEnum {

    /**
     * 群组创建者
     */
    GROUP_ROLE_OWNER("GROUP_ROLE_OWNER", "0", "群组创建者"),

    /**
     * 群组管理员
     */
    GROUP_ROLE_MANAGER("GROUP_ROLE_MANAGER", "1", "群组管理员"),

    /**
     * 普通成员
     */
    GROUP_ROLE_MEMBER("GROUP_ROLE_MEMBER", "2", "普通成员");

    private String code;
    private String auth;
    private String msg;
}
