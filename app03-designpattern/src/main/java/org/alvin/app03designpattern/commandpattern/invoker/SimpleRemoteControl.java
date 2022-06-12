package org.alvin.app03designpattern.commandpattern.invoker;

import org.alvin.app03designpattern.commandpattern.command.Command;

/**
 * 一个简单的遥控器实现类，假设遥控器上只有一个插槽可用，且只有一个“打开”按钮。
 * 遥控器上的每个插槽用于控制一个家电（如，卧室灯、音箱）。
 * 作为调用者示例。通过命令对象将调用者与接受者解耦，使调用者尽可能地简单。
 * 同时，可以做到增加五花八门的、接口形式各不相同的接受者时，不用修改调用者的代码。
 */
public class SimpleRemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    /**
     * “打开”按钮被按下，执行家电打开任务（命令）。
     */
    public void buttonWasPushed() {
        slot.execute();
    }
}
