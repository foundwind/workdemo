package 设计模式.工厂模式;

/**
 * @author XuYiPeng
 * @Description 具体工厂
 * @date 2022/6/2
 */
public class GoodCreator extends Creator {

    @Override
    protected Product createProduct() {
        return new GoodProduct();
    }

}
