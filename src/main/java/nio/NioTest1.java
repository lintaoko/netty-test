package nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest1 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream=new FileInputStream("/nio/abc.txt");
        FileChannel fileChannel =fileInputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining()>0 && byteBuffer.hasRemaining()){
            byte b =byteBuffer.get();
            System.out.println("Character:"+(char)b);
        }
        fileChannel.close();
    }
}
