package cn.nanchaos.nim.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Default Description
 * 用户和群组关系表
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_with_group_ship")
public class UserWithGroupShipDO implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 是否在群组中：
     * - 0：不在
     * - 1：在
     */
    private String inGroupStatus;

    /**
     * 详见：UserSetGroupMsgStatusEnum
     * 群组消息状态：
     * - 0，接受并提醒
     * - 1，接受但不提醒
     * - 2，屏蔽群消息
     */
    private String groupMsgStatus;

    /**
     * 群昵称备注
     */
    private String groupNameRemark;

    /**
     * 用户名称在群备注
     */
    private String userNickNameInGroup;

    /**
     * 消息是否置顶
     * 详见：UserSetGroupMsgTopStatus
     */
    private String markMsgTop;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 更新人
     */
    private String updatedBy;
}
