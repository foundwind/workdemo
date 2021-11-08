import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Test1 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\data_20210830_092608.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        int len = "QDM-MDSPCX-2021082703268".length();
        HashSet<String> hashSet = new HashSet<>();
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null || line.equals("")) {
                break;
            }
            try {
                int outerCode1 = line.indexOf("outerCode");
                String outerCode = line.substring(outerCode1 + 14, outerCode1 + 38);
                if (!outerCode.contains("QDM-MDSPCX")){
                    System.out.println("奇怪");
                    System.out.println(line);
                }

//                JSONObject object = JSON.parseObject(line);
//                String message = object.getString("message");
//                int of = message.indexOf("com.zhuizhi.");
//                String substring = message.substring(0, of);
//                String replaceAll = substring.replaceAll("oa批量推送临促入库失败：", "");
//                JSONObject parse = JSON.parseObject(replaceAll);
//                String outerCode = parse.getString("outerCode");
                hashSet.add(outerCode);
            }catch (Exception e){
                System.out.println("caoni");
                System.out.println(line);
            }
        }

        for (String s : hashSet) {
            System.out.println(s);

        }
    }


}

