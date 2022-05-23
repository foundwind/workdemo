package 设计模式.策略模式;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/5/23
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}
