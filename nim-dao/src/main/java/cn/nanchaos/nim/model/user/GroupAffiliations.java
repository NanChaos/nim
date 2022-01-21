package cn.nanchaos.nim.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/21
 * @time: 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupAffiliations implements Serializable {
    private String owner;

    /**
     * 管理员列表
     */
    private List<String> managersUid;

    /**
     * 普通成员列表
     */
    private List<String> membersUid;

    /**
     * 待审核列表
     */
    private List<String> toBeAuditList;
}
