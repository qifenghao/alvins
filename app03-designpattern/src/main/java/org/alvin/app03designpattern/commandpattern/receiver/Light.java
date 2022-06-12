package org.alvin.app03designpattern.commandpattern.receiver;

/**
 * 灯，例如卧室灯、厨房灯。
 * 作为接收器示例，实际的任务执行者。
 */
public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is on");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}
