package cn.nanchaos.nim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Default Description
 * protocol
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 9:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Protocol {
    protected boolean bridge;
    protected int type;
    protected String dataContent;
    protected String from;
    protected String to;
    protected String fp;
    protected boolean QoS;
    protected int typeU;
    protected transient int retryCount;
    protected long sm;

}
