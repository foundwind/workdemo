package 设计模式.工厂模式;

/**
 * @author XuYiPeng
 * @Description 抽象工厂方法
 * @date 2022/6/2
 */
public abstract class Creator {

    public void doOperator() {
        Product product = createProduct();
        product.doSomething();
    }

    protected abstract Product createProduct();

}
