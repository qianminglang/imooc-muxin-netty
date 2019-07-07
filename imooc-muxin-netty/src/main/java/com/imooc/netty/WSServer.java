package com.imooc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @description: netty服务端
 * @author: qml
 * @create: 2019-07-07 14:46
 */
@Component
public class WSServer {
    private static class SingletonWSServer{
        private final static WSServer instance =new WSServer();
    }

    public  static WSServer getInstance(){
        return SingletonWSServer.instance;
    }


    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;

    public WSServer(){
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup,subGroup).channel(NioServerSocketChannel.class)
                .childHandler(new WebServerInitializer());
    }

    public void start(){
        ChannelFuture future = server.bind(8088);
        System.err.println("netty websocket server 启动完毕。。。");
    }
}
