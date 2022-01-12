package qdm_utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author XuYiPeng
 * @Description 价格策略门店店号变更工具类
 * @date 2021/11/30
 */
public class PriceShopNoModify {

    public static void main(String[] args) throws Exception {
        // 读写文件流
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\QDM\\Desktop\\applicationContext.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\QDM\\Desktop\\applicationContext1.txt")));
        // 获取需要换店号的map
        Map<String, String> shopNoMap = getMap();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // 读取一行数据，如果为空就跳出
            String line = reader.readLine();
            if (line == null) break;

            for (String key : shopNoMap.keySet()) {
                if (line.contains(key)) {
                    System.out.println(line);
                    set.add(key);
                    line = line.replace(key, shopNoMap.get(key));
                }
            }
            writer.write(line + "\r\n");
        }
        Set<String> strings = shopNoMap.keySet();
        strings.removeAll(set);
        System.out.println(set);
        System.out.println(strings);

        // 关闭流操作
        reader.close();
        writer.close();
    }

    private static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("A12G", "A7Y1");
        map.put("A055", "A7Y4");
        map.put("A128", "A8Y2");
        map.put("A173", "A8Y5");
        map.put("A18D", "A8Y6");
        map.put("A476", "A4YR");
        map.put("A12D", "A4YU");
        map.put("A003", "A4YV");
        map.put("A02U", "A4YW");
        map.put("A03Y", "A4YX");
        map.put("A04F", "A4YY");
        map.put("A04K", "A4YZ");
        map.put("A08A", "A5YB");
        map.put("A08V", "A5YC");
        map.put("A105", "A5YD");
        map.put("A144", "A5YE");
        map.put("A160", "A5YF");
        map.put("A3A3", "A55D");
        map.put("A3A5", "A03T");
        map.put("A17T", "A5YI");
        map.put("A005", "A5YJ");
        return map;
    }
}
