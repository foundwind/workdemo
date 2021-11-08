import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2021/8/2
 */
public class MD5Test {

    public static void main(String[] args) throws Exception {
        System.out.println(9%9);

        long now = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        List<String> skus = new ArrayList<>();
        List<String> shops = new ArrayList<>();

        String nowStr = "20210802";

        String skuCode = "'20000011','20000028','20000035','20000042','20000059','20000066','20000073','20000080','20000097','20000103','20000110','20000127','20000134','20000141','20000158','20000165','20000189','20000196','20000219','20000226','20000233','20000240','20000264','20000271','20000288','20000295','20000301','20000318','20000325','20000332','20000349','20000356','20000363','20000370','20000387','20000394','20000400','20000417','20000431','20000448'";

        for (String s : skuCode.split(",")) {
            skus.add(s.replaceAll("'", ""));
        }


        File file = new File("C:\\Users\\Administrator\\Desktop\\new 5.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            shops.add(line);
        }

//        System.out.println(skus);
        for (String shop : shops) {
            for (String s : skus) {
                String s1 = shop + s + nowStr;
//                System.out.println(s1);
                result.add(md5(s1));
            }
        }
//        System.out.println(result);

        for (int i = 0; i < 10000; i++) {
            System.out.println("'"+result.get(i)+"'"+",");
        }
    }


    public static String md5(String key) {
        String md5 = null;
        char[] hexDigits = { // 用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f'};
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        byte[] defaultBytes = key.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte[] messageDigest = algorithm.digest();
            char[] str = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = messageDigest[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            md5 = new String(str); // 换后的结果转换为字符串

        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return md5;

    }
}
