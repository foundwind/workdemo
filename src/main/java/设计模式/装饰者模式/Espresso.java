package 设计模式.装饰者模式;

import java.math.BigDecimal;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/5/27
 */
public class Espresso extends  Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("11");
    }

}
