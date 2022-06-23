package 设计模式.命令模式;

/**
 * @author XuYiPeng
 * @Description 具体命令类
 * @date 2022/6/23
 */
public class ConcreteCommand implements Command {

    private Action action;

    public ConcreteCommand(Action action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.doSomething();
    }

    @Override
    public void undo() {
        action.undoSomething();
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
