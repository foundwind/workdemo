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

        map.put("A57A", "A8Y9");
        map.put("A16N", "A9Y4");
        map.put("A255", "A9Y5");
        map.put("A15P", "A9Y6");
        map.put("A11D", "A9Y7");
        map.put("A05C", "A9Y8");


        return map;
    }
}
