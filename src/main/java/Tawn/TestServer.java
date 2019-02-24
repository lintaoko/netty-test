package Tawn;


import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class TestServer {
    public static void main(String[] args) {
        EventLoopGroup boosGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();
    }
}
