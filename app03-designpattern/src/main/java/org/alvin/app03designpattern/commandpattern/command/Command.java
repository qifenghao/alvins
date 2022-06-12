package org.alvin.app03designpattern.commandpattern.command;

/**
 * 具体命令实现此接口
 */
public interface Command {
    /**
     * 执行命令，通常情况是委托给接受者执行任务，以此达到调用者和接受者解耦。
     * 有时也会自己实现执行任务的代码。
     */
    void execute();
}
