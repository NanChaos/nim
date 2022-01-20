package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Default Description
 *
 * @author: nanchaos
 * @time: 2022/1/20
 */
@Getter
@AllArgsConstructor
public enum HeartbeatEnum_UDP {
    /**
     *
     */
    MODE_3S("MODE_3S",3),

    /**
     *
     */
    MODE_10S("MODE_10S",10),

    /**
     *
     */
    MODE_30S("MODE_30S",30),

    /**
     *
     */
    MODE_60S("MODE_60S",60),

    /**
     *
     */
    MODE_120S("MODE_120S",120);

    private String code;
    private Integer frequency;
}
