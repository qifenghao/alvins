package org.alvin.app03designpattern.commandpattern.command;

import org.alvin.app03designpattern.commandpattern.receiver.Light;

/**
 * 灯具打开命令，需持有要控制的灯具对象。
 * 执行打开命令时，将打开工作委托给对应的灯具对象。
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
