package 设计模式.装饰者模式;

import java.math.BigDecimal;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/5/27
 */
public abstract class Beverage {

    protected String description = "UN_KNOW";

    public abstract BigDecimal cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
