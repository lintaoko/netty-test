package netty.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class MyServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup boosGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try {
            //服务端启动
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class).
                    childHandler(new MyServerInitializer());
            //端口绑定于8899
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            //关闭
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

