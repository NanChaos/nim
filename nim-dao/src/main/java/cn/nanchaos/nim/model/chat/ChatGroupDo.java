package cn.nanchaos.nim.model.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Default Description
 * 存储的是聊天群组的MySQL信息
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 16:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGroupDo implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * avatar
     */
    private String avatar;

    /**
     * 群组名
     */
    private String groupName;

    /**
     * 群组简介
     */
    private String groupDescription;

    /**
     * 群组公告
     */
    private String groupNotice;

    /**
     * 群组类型
     */
    private String groupType;

    /**
     * ownerId
     * 一般情况下是人持有，但是后期可能会有机构类型，所以为Id，而非Uid
     */
    private Integer ownerId;

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
