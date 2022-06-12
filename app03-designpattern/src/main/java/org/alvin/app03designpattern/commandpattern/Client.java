package org.alvin.app03designpattern.commandpattern;

import org.alvin.app03designpattern.commandpattern.command.Command;
import org.alvin.app03designpattern.commandpattern.command.LightOnCommand;
import org.alvin.app03designpattern.commandpattern.invoker.SimpleRemoteControl;
import org.alvin.app03designpattern.commandpattern.receiver.Light;

/**
 * 命令模式：封装方法调用。
 */
public class Client {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living room");
        Command lightOnCommand = new LightOnCommand(livingRoomLight);

        SimpleRemoteControl remote = new SimpleRemoteControl();
        remote.setCommand(lightOnCommand);

        // 打开卧室灯
        remote.buttonWasPushed();
    }
}
