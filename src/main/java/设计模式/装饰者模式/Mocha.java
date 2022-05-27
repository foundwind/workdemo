package 设计模式.装饰者模式;

import java.math.BigDecimal;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/5/27
 */
public class Mocha extends Decorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return beverage.cost().add(new BigDecimal("1.1"));
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
