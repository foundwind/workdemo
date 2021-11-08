package demo.json;

//import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonDemmo2 {



    public static void main(String[] args) throws Exception {
        System.out.println(false || false && true);
//        read();
    }

    public static void read() throws Exception {


        File file2 = new File("C:\\Users\\Administrator\\Desktop\\新建文本文档 (2).txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));//构造一个BufferedReader
        String s2 = null;

        HashMap<String, String> map = new HashMap<>();
        while((s2 = br2.readLine())!=null){//使用readLine方法，一次读一行
            String[] arrayStr = s2.split("-");
            map.put(arrayStr[1],arrayStr[0]);
        };










        File file = new File("C:\\Users\\Administrator\\Desktop\\jiage.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader
        String s = null;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String[] arrayStr = s.split("#");
            System.out.println("update t_price_finally set current_price = " + arrayStr[2].trim() + " where calc_effect_at = '2020-11-28' and shop_id = '" + map.getOrDefault(arrayStr[1].trim(),arrayStr[1].trim()) + "' and sku_code ='" + arrayStr[0].trim() + "';");
        };

//        HashSet<String> set = new HashSet<>();
//        File file3 = new File("C:\\Users\\Administrator\\Desktop\\guolv.txt");
//        BufferedReader br3 = new BufferedReader(new FileReader(file3));//构造一个BufferedReader
//        String s3 = null;
//        while((s3 = br3.readLine())!=null){//使用readLine方法，一次读一行
//            set.add(s3);
//        };
//
//
//
//
//
//
//        File file2 = new File("C:\\Users\\Administrator\\Desktop\\更新sql.txt");
//        BufferedReader br2 = new BufferedReader(new FileReader(file2));//构造一个BufferedReader
//        String s2 = null;
//        while((s2 = br2.readLine())!=null){//使用readLine方法，一次读一行
//            String[] split = s2.split("#");
//            if (set.contains(shopMap.get(split[0]))) {
//               System.out.println("update t_price_finally set current_price = " + split[2] + " where calc_effect_at = '2020-09-09' and shop_id = '" + shopMap.get(split[0]) + "' and sku_code ='" + split[1] + "';");
//            }
//
//        };





//br2.close();
        br.close();
    }




    public static void read1() throws Exception {
        Date date = new Date();
        Date date1 = new Date(date.getTime());
        System.out.println(date.after(date1));
        File file = new File("C:\\Users\\Administrator\\Desktop\\json.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader
        String s = null;
        BigDecimal a = BigDecimal.ZERO;
        Set<String> skuSet = new HashSet<>();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String[] split = s.split(",");
            for (String s1 : split) {
                if (skuSet.contains(s1)){
                    System.out.println(s1);
                }else {
                    skuSet.add(s1);
                }
            }

        };
        System.out.println("update t_price_finally set current_price = " + 0 + "where calc_effect_at = '2020-09-09' and sku_code = and shop_id = ");

        br.close();
    }






















//
//    public static void calculate() throws Exception {
//        Date date = new Date();
//        Date date1 = new Date(date.getTime());
//        System.out.println(date.after(date1));
//        File file = new File("C:\\Users\\Administrator\\Desktop\\json.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader
//        String s = null;
//        BigDecimal a = BigDecimal.ZERO;
//        Set<String> skuSet = new HashSet<>();
//        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
//            List<Map<String, String>> result = new Gson().fromJson(s, ArrayList.class);
//            System.out.println(result.size());
//            for (Map<String, String> map : result) {
//                a = a.add(new BigDecimal(map.get("settleQty")));
//                String skuCode = map.get("settleSkuCode");
//                int size = skuSet.size();
//                skuSet.add(skuCode);
//                if (skuCode.equals("20057176")){}
//                if (size == skuSet.size()){
//                    System.out.println(new BigDecimal(map.get("settleQty")));
//                    System.out.println(skuCode);
//                }
//            }
//        };
//        System.out.println(skuSet.size());
//        System.out.println(a);
//        br.close();
//    }
//
//    public static void highToLow() throws Exception{
//        File file = new File("C:\\Users\\Administrator\\Desktop\\json.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader
//        String s = null;
//        HashSet<String> set = new HashSet<>();
//        BigDecimal hello = BigDecimal.ZERO;
//        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
//            List<Map<String, Object>> result = new Gson().fromJson(s, ArrayList.class);
////            System.out.println(result.size());
//            List<Map<String, Object>> result2 = new ArrayList<>();
//            for (Map<String, Object> map : result) {
////                hello = hello.add(new BigDecimal(map.get("settleQty")));
//                HashMap<String, Object> hashMap = new HashMap<>();
//                for (String key : map.keySet()) {
//                    Object value = map.get(key);
//                    String lowerCase = key.toLowerCase();
//                    hashMap.put(lowerCase,value);
//                }
//                result2.add(hashMap);
//            }
////            System.out.println(hello);
//            System.out.println(new Gson().toJson(result2).toString());
//        };
//        br.close();
//    }
//
//    public static void highToLow2() throws Exception{
//        File file = new File("C:\\Users\\Administrator\\Desktop\\json.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader
//        String s = null;
//        HashSet<String> set = new HashSet<>();
//        BigDecimal hello = BigDecimal.ZERO;
//        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
//            Map<String,Object> result = new Gson().fromJson(s, Map.class);
////            System.out.println(result.size());
//            Map<String,Object> result2 = new HashMap<>();
//            for (String key : result.keySet()) {
//                Object value = result.get(key);
//                String lowerCase = key.toLowerCase();
//                result2.put(lowerCase,value);
//            }
////            System.out.println(hello);
//            System.out.println(new Gson().toJson(result2).toString());
//        };
//        br.close();
//    }
}