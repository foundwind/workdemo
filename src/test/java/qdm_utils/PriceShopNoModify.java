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

        map.put("A52L", "A4Y2");
        map.put("A58S", "A5Y1");
        map.put("A64R", "A5Y2");
        map.put("A570", "A5Y6");
        map.put("A00D", "A5Y9");
        map.put("A00L", "A6Y0");
        map.put("A64J", "A6Y1");
        map.put("A53Y", "A6Y2");
        map.put("A05S", "A6Y4");
        map.put("A156", "A6Y6");
        map.put("A009", "A6Y7");
        map.put("A14D", "A6Y8");
        map.put("A09L", "A6Y9");
        map.put("A591", "A7Y2");
        map.put("A561", "A7Y3");
        map.put("A36F", "A7Y6");
        map.put("A00S", "A7Y7");
        map.put("A46X", "A7Y8");
        map.put("A00Q", "A7Y9");
        map.put("A41E", "A8Y0");
        map.put("A275", "A8Y1");
        map.put("A478", "A8Y3");
        map.put("A002", "A8Y4");
        map.put("A0O1", "A8Y7");

        return map;
    }
}
