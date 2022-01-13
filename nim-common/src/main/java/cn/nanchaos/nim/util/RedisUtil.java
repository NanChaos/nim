package cn.nanchaos.nim.util;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/13
 * @time: 17:56
 */
public class RedisUtil {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
}
