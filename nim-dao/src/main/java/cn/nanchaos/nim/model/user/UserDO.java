package cn.nanchaos.nim.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Default Description
 *
 * @author: nanchaos
 * @time: 2022/1/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     * email
     */
    private String email;

    /**
     * pass
     */
    private String password;

    /**
     * salt
     */
    private String salt;

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
