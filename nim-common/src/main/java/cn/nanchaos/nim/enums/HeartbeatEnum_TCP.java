package cn.nanchaos.nim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Default Description
 *
 * @author: nanchaos
 * @time: 2022/1/20
 */
@Getter
@AllArgsConstructor
public enum HeartbeatEnum_TCP {
    /**
     *
     */
    MODE_3S("MODE_3S",3),

    /**
     *
     */
    MODE_5S("MODE_5S",5),

    /**
     *
     */
    MODE_10S("MODE_10S",10),

    /**
     *
     */
    MODE_15S("MODE_15S",15),

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
