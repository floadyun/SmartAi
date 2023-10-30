package com.ruoyi.chat.server;

import com.ruoyi.chat.handler.ChatServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: yixiaofei
 * @description:
 * @date: 2023/10/30 17:37
 */
@Component
public class AIChatServer {

    @Value("${websocket.port}")
    private int port;

    private ServerBootstrap bootstrap;

    private EventLoopGroup mainGroup,subGroup;

    private ChannelFuture future;

    public AIChatServer() {
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(mainGroup,subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new ChatServerHandler());
                    }
                });
    }

    public void start(){
        this.future = bootstrap.bind(port);
    }
}
