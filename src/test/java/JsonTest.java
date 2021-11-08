import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2021/8/10
 */
public class JsonTest {

    public static void main(String[] args) {
        System.out.println(MessageFormat.format("上次调价日 前21天平均19点前客流为 {1}，当前近21天平均19点前客流为 {2}，则以下分类将按下表进行下调价格，下调后预计客流会有所上升", 1, 2, 3, 4, 5));


        int shopId = 101001;
        int i = 0;
        int skuCode = 20010001;
        int s = 0;


        List<OAPromotionReq> reqs = new ArrayList<>();

        List<OAPromotionReq.OAPromotionSku> skuCodeList = new ArrayList<>();


        for (int j = 0; j < 20; j++) {
            OAPromotionReq.OAPromotionSku sku = new OAPromotionReq.OAPromotionSku();
            sku.setWeekType(1);
            sku.setStartAt("2021-08-10");
            sku.setEndAt("2021-08-11");
            sku.setCode(skuCode + s + "");
            sku.setRuleType("RATE_UP");
            sku.setPriceType("PRICE");
            sku.setRuleValue("1");
            sku.setName("测试商品" + s++);
            skuCodeList.add(sku);
        }

        for (int j = 0; j < 200; j++) {
            OAPromotionReq req = new OAPromotionReq();
            req.setPromotionName("测试" + i);
            req.setPromotionType("你好");
            req.setShopList(Arrays.asList(shopId + i ++ + ""));
            req.setSkus(skuCodeList);
            reqs.add(req);

        }
        System.out.println(JSON.toJSON(reqs));


    }
}
