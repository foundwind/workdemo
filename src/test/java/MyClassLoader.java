import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/2/6
 */
public class MyClassLoader extends ClassLoader {


    public static void main (String[] args) throws Exception {
        System.out.println(new MyClassLoader().getThirtySevenByte(17, 2));

    }


    public MyClassLoader() {

    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("C:\\Users\\QDM\\Desktop\\People.class");
        try {
            byte[] bytes = getClassBytes(file);

            //defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }

    private static final String PATTERN = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String getThirtySevenByte(Integer num , int level) {
        /*
         * 这里的逻辑，是传入数字和要生成的位数
         * 不断地拿0-9A-Z中的值，最终反转,拼接为单号
         *
         */
        int count = 0;
        int current = num;

        StringBuilder result = new StringBuilder();
        while(count < level && current >= 0) {
            result.append(PATTERN.charAt(current % 36));
            current = current / 36;
            count ++;
        }
        result.setLength(level);
        result.reverse();
        return result.toString();
    }

}
