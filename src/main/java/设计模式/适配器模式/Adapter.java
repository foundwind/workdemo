package 设计模式.适配器模式;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/6/30
 */
public class Adapter extends Target {

    private Other other;

    public Adapter(Other other) {
        this.other = other;
    }

    @Override
    public void doSomething() {
        other.doOtherThing();
    }

}
