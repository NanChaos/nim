package cn.nanchaos.nim.mapper.msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Default Description
 * 消息体 抽象---已丢弃
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 16:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class MessageBody implements Serializable {
    String msgType;
}
