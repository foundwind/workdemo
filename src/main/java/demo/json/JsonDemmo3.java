package demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonDemmo3 {


    public static void main(String[] args) throws Exception {
        String a = "[{\"salePrice\":8.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20000042\"},{\"salePrice\":8.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20000141\"},{\"salePrice\":6.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20000646\"},{\"salePrice\":14.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20001292\"},{\"salePrice\":45.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002527\"},{\"salePrice\":38.9000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002589\"},{\"salePrice\":56.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002596\"},{\"salePrice\":45.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002602\"},{\"salePrice\":161.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002619\"},{\"salePrice\":39.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002633\"},{\"salePrice\":63.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002664\"},{\"salePrice\":53.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002732\"},{\"salePrice\":44.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002749\"},{\"salePrice\":37.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20002794\"},{\"salePrice\":77.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003173\"},{\"salePrice\":35.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003203\"},{\"salePrice\":47.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003210\"},{\"salePrice\":55.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003470\"},{\"salePrice\":41.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003524\"},{\"salePrice\":33.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003654\"},{\"salePrice\":43.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003692\"},{\"salePrice\":11.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003722\"},{\"salePrice\":25.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003784\"},{\"salePrice\":11.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003876\"},{\"salePrice\":112.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003920\"},{\"salePrice\":95.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003944\"},{\"salePrice\":109.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20003951\"},{\"salePrice\":27.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20010546\"},{\"salePrice\":30.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20010713\"},{\"salePrice\":37.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20012670\"},{\"salePrice\":3.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20014698\"},{\"salePrice\":35.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20015848\"},{\"salePrice\":9.7500,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20016098\"},{\"salePrice\":11.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20017286\"},{\"salePrice\":15.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20017392\"},{\"salePrice\":25.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20017828\"},{\"salePrice\":6.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20020002\"},{\"salePrice\":19.9600,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20038328\"},{\"salePrice\":18.1600,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20041151\"},{\"salePrice\":12.3300,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20041168\"},{\"salePrice\":1.5000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20042103\"},{\"salePrice\":10.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20042134\"},{\"salePrice\":11.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20042271\"},{\"salePrice\":23.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20042578\"},{\"salePrice\":14.1000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20042585\"},{\"salePrice\":28.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20042639\"},{\"salePrice\":21.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20043179\"},{\"salePrice\":14.1200,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20043605\"},{\"salePrice\":87.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20044794\"},{\"salePrice\":20.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20045364\"},{\"salePrice\":3.3900,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20046248\"},{\"salePrice\":8.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20047184\"},{\"salePrice\":30.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20047535\"},{\"salePrice\":13.9900,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20050054\"},{\"salePrice\":12.4300,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20050061\"},{\"salePrice\":12.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20053284\"},{\"salePrice\":16.9000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20053604\"},{\"salePrice\":10.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20054274\"},{\"salePrice\":25.9000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20054441\"},{\"salePrice\":30.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20055714\"},{\"salePrice\":116.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20055912\"},{\"salePrice\":21.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20056537\"},{\"salePrice\":10.5300,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20057176\"},{\"salePrice\":13.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20057282\"},{\"salePrice\":6.7000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20057299\"},{\"salePrice\":12.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20057343\"},{\"salePrice\":8.3300,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20057541\"},{\"salePrice\":10.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20057992\"},{\"salePrice\":8.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20058067\"},{\"salePrice\":17.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20058753\"},{\"salePrice\":9.6400,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20058876\"},{\"salePrice\":11.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20059019\"},{\"salePrice\":58.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20061012\"},{\"salePrice\":17.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20061050\"},{\"salePrice\":23.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20061258\"},{\"salePrice\":8.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20061418\"},{\"salePrice\":11.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20063702\"},{\"salePrice\":68.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20065997\"},{\"salePrice\":8.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20067120\"},{\"salePrice\":15.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20071073\"},{\"salePrice\":10.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20076658\"},{\"salePrice\":38.9000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20078355\"},{\"salePrice\":47.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20080105\"},{\"salePrice\":24.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20080112\"},{\"salePrice\":23.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20080136\"},{\"salePrice\":13.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20087050\"},{\"salePrice\":21.1000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20089504\"},{\"salePrice\":10.5400,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20089580\"},{\"salePrice\":14.1000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20096588\"},{\"salePrice\":7.9700,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20101398\"},{\"salePrice\":31.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20102999\"},{\"salePrice\":10.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20103767\"},{\"salePrice\":49.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20105877\"},{\"salePrice\":25.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20105884\"},{\"salePrice\":24.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20107468\"},{\"salePrice\":14.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20107475\"},{\"salePrice\":59.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20116576\"},{\"salePrice\":10.6000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20117276\"},{\"salePrice\":10.8000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20117986\"},{\"salePrice\":14.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20120252\"},{\"salePrice\":17.2200,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20544966\"},{\"salePrice\":11.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20560416\"},{\"salePrice\":13.6800,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20573768\"},{\"salePrice\":13.6300,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20582159\"},{\"salePrice\":61.4000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20609122\"},{\"salePrice\":11.5000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20633943\"},{\"salePrice\":7.8500,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20672423\"},{\"salePrice\":22.0000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20678395\"},{\"salePrice\":44.9000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20740641\"},{\"salePrice\":5.5000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20810528\"},{\"salePrice\":9.2000,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20831172\"},{\"salePrice\":17.7700,\"saleStatus\":\"DELIST\",\"shopId\":\"A1SF\",\"skuCode\":\"20904692\"}]";
        String b = "20000042\n" +
                "20000141\n" +
                "20000646\n" +
                "20002527\n" +
                "20002589\n" +
                "20002596\n" +
                "20002602\n" +
                "20002619\n" +
                "20002633\n" +
                "20002664\n" +
                "20002732\n" +
                "20002749\n" +
                "20002794\n" +
                "20003173\n" +
                "20003203\n" +
                "20003210\n" +
                "20003470\n" +
                "20003524\n" +
                "20003654\n" +
                "20003692\n" +
                "20003722\n" +
                "20003784\n" +
                "20003876\n" +
                "20003920\n" +
                "20003944\n" +
                "20003951\n" +
                "20010546\n" +
                "20010713\n" +
                "20012670\n" +
                "20015848\n" +
                "20016098\n" +
                "20017286\n" +
                "20017392\n" +
                "20017828\n" +
                "20020002\n" +
                "20038328\n" +
                "20041151\n" +
                "20041168\n" +
                "20042103\n" +
                "20042134\n" +
                "20042271\n" +
                "20042578\n" +
                "20042585\n" +
                "20042639\n" +
                "20043179\n" +
                "20043605\n" +
                "20044794\n" +
                "20045364\n" +
                "20046248\n" +
                "20046279\n" +
                "20047184\n" +
                "20047535\n" +
                "20050054\n" +
                "20050061\n" +
                "20053284\n" +
                "20053604\n" +
                "20054274\n" +
                "20054441\n" +
                "20055714\n" +
                "20055912\n" +
                "20056537\n" +
                "20057176\n" +
                "20057282\n" +
                "20057299\n" +
                "20057343\n" +
                "20057541\n" +
                "20057992\n" +
                "20058753\n" +
                "20058876\n" +
                "20059019\n" +
                "20061012\n" +
                "20061050\n" +
                "20061258\n" +
                "20061418\n" +
                "20063702\n" +
                "20065997\n" +
                "20067120\n" +
                "20071073\n" +
                "20076658\n" +
                "20080105\n" +
                "20080112\n" +
                "20080136\n" +
                "20087050\n" +
                "20089504\n" +
                "20089580\n" +
                "20096588\n" +
                "20101398\n" +
                "20102999\n" +
                "20103767\n" +
                "20105877\n" +
                "20105884\n" +
                "20107468\n" +
                "20107475\n" +
                "20116576\n" +
                "20117276\n" +
                "20117986\n" +
                "20120252\n" +
                "20544966\n" +
                "20560416\n" +
                "20573768\n" +
                "20582159\n" +
                "20609122\n" +
                "20633943\n" +
                "20672423\n" +
                "20740641\n" +
                "20810528\n" +
                "20831172\n" +
                "20861360\n" +
                "20904692\n" +
                "\n" +
                "\n" +
                "\n";
        String[] split = b.split("\n");

        List<Integer> haves = Stream.of(split).map(e->Integer.valueOf(e)).collect(Collectors.toList());
        List<JSONObject> objects = JSON.parseArray(a, JSONObject.class);
        List<Integer> asd = new ArrayList<>();
        for (JSONObject object : objects) {
            Integer skuCode = object.getInteger("skuCode");
            asd.add(skuCode);
        }
        // 查询的
        List<Integer> collect = asd.stream().sorted().collect(Collectors.toList());

        System.out.println(haves.size());
        System.out.println(collect.size());
        collect.removeIf(e->!haves.contains(e));
        System.out.println(collect.size());


    }


}