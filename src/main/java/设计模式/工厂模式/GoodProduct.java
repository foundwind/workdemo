package 设计模式.工厂模式;

/**
 * @author XuYiPeng
 * @Description 具体产品
 * @date 2022/6/2
 */
public class GoodProduct extends Product {

    @Override
    public void doSomething() {
        System.out.println("do very good");
    }

}
