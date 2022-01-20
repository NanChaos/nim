package cn.nanchaos.nim.network.tcp;

import cn.nanchaos.nim.Gateway;
import cn.nanchaos.nim.ServerCoreHandler;
import cn.nanchaos.nim.common.CommonConstant;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.ReadTimeoutException;
import lombok.extern.slf4j.Slf4j;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/20
 * @time: 9:57
 */
@Slf4j
public class NimTcpClientInboundHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private ServerCoreHandler serverCoreHandler = null;

    public NimTcpClientInboundHandler(ServerCoreHandler serverCoreHandler) {
        this.serverCoreHandler = serverCoreHandler;
    }

    /**
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        Gateway.setSocketType(ctx.channel(), CommonConstant.SYSTEM_INTEGER_TWO);

    }

    /**
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    /**
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    /**
     * @param ctx
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

    }


    /**
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        try {
            if (cause instanceof ReadTimeoutException) {
                log.info("[NIM-SERVER-TCP]:客户端连接超时:{}", ctx.channel());
            }
        } catch (Exception e) {
            log.error("", e);
            throw new Exception();
        }
    }
}
