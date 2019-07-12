package nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream=new FileOutputStream("abc.txt");
        FileChannel fileChannel=fileOutputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(512);
        byte[] message ="Hello Tawn".getBytes();

        for (byte a:message) {
        byteBuffer.put(a);
        }
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileChannel.close();
    }
}
