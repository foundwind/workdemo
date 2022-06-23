package 设计模式.命令模式;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/6/23
 */
public class Invoker {

    private Command[] commands;

    private int len;

    public Invoker(int len) {
        this.commands = new Command[len];
        NullCommand nullCommand = new NullCommand();
        for (Command command : this.commands) {
            command = nullCommand;
        }
    }

    public void setOneCommand(int slot, Command command) {
        this.commands[slot] = command;
    }

    public void onButtonPush(int slot) {
        commands[slot].execute();
    }

    public void undo(int slot) {
        commands[slot].undo();
    }

}
