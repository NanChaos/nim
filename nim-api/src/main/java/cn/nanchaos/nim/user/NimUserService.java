package cn.nanchaos.nim.user;

import cn.nanchaos.nim.response.Result;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 14:48
 */
public interface NimUserService {
    /**
     * 用户注册，
     * 此调用nus提供的api，用户全部注册到nus上
     *
     * @return
     */
    Result<Boolean> userSignIn();

    /**
     * 用户登录
     * 此调用nus提供的api，nus负责验证信息
     *
     * @return
     */
    Result userLogin();

    /**
     * 用户登出
     * 此调用nus提供的api，nus负责登出
     *
     * @return
     */
    Result userLogout();

    /**
     * 用户销户
     *
     * @return
     */
    Result userSoldOut();


    /**
     * 设置用户属性
     *
     * @return
     */
    Result saveUserMetaData();

    /**
     * 更新用户属性
     *
     * @return
     */
    Result updateUserMetaData();

    /**
     * 用户好友列表关系详情
     *
     * @return
     */
    Result userFriendsShip();

    /**
     * 用户已参加群组列表详情
     *
     * @return
     */
    Result userParticipatedGroupsShip();
}
