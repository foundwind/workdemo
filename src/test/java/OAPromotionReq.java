
import java.io.Serializable;
import java.util.List;

/**
 * @author xieb
 * @date 2019.09.21
 */
public class OAPromotionReq implements Serializable {

    private static final long serialVersionUID = 7321746458982608924L;
    private String promotionName;
    private String promotionType;
    private List<String> regionList;
    private List<String> shopList;
    private List<OAPromotionSku> categorySkus;
    private List<OAPromotionSku> skus;

    public static class OAPromotionSku {

        private String code;
        private String name;
        private String startAt;
        private String endAt;
        private Integer weekType;
        private String ruleType;
        private String priceType;
        private String ruleValue;

        public Integer getWeekType() {
            return weekType;
        }

        public void setWeekType(Integer weekType) {
            this.weekType = weekType;
        }

        public String getStartAt() {
            return startAt;
        }

        public void setStartAt(String startAt) {
            this.startAt = startAt;
        }

        public String getEndAt() {
            return endAt;
        }

        public void setEndAt(String endAt) {
            this.endAt = endAt;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRuleType() {
            return ruleType;
        }

        public void setRuleType(String ruleType) {
            this.ruleType = ruleType;
        }

        public String getPriceType() {
            return priceType;
        }

        public void setPriceType(String priceType) {
            this.priceType = priceType;
        }

        public String getRuleValue() {
            return ruleValue;
        }

        public void setRuleValue(String ruleValue) {
            this.ruleValue = ruleValue;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public List<String> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<String> regionList) {
        this.regionList = regionList;
    }

    public List<String> getShopList() {
        return shopList;
    }

    public void setShopList(List<String> shopList) {
        this.shopList = shopList;
    }

    public List<OAPromotionSku> getCategorySkus() {
        return categorySkus;
    }

    public void setCategorySkus(List<OAPromotionSku> categorySkus) {
        this.categorySkus = categorySkus;
    }

    public List<OAPromotionSku> getSkus() {
        return skus;
    }

    public void setSkus(List<OAPromotionSku> skus) {
        this.skus = skus;
    }
}
