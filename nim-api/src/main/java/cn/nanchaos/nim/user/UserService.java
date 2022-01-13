package cn.nanchaos.nim.user;


import cn.nanchaos.nim.response.Result;

/**
 * Default Description
 *
 * @author: nanchaos
 * @time: 2022/1/13
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @return
     */
    Result<Boolean> userSignIn();

    /**
     * 用户登录
     *
     * @return
     */
    Result userLogin();

    /**
     * 用户登出
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
     * 用户好友关系详情
     *
     * @return
     */
    Result userFriendsShip();

    /**
     * 用户已参加群组详情
     *
     * @return
     */
    Result userParticipatedGroupsShip();
}
