package com.imooc.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @description: 初始化
 * @author: qml
 * @create: 2019-07-03 10:25
 */
public class WebServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        //websocket基于http协议，所以要有http编解码器
        pipeline.addLast(new HttpServerCodec());

        //对大数据流的支撑
        pipeline.addLast(new ChunkedWriteHandler());

        //对httpmessage聚合，聚合成FullHeepRequest或者FullHttpResponse
        //几乎所有netty编程中，都会使用此handler
        pipeline.addLast(new HttpObjectAggregator(1024*64));
        //======================以上是基于http协议======================================
        //======================以下是基于httpwebsocket协议============================================
        /**
         * websocket 服务器处理的协议，用于指定给客户端连接访问的路由：/ws
         * 本handler会帮你处理一些繁重的事
         * 会帮你处理握手动作，handshacking（close，ping，pong） ping+pong=心跳
         * 对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
         * */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        //自定义handler
        pipeline.addLast(new ChatHandler());
    }
}
