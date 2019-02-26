package Tawn;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
//初始化器
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline =ch.pipeline();
        //用于响应编解码
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        //自定义Handler
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());

    }
}
