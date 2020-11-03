package com.blog.demo.design.command;

public class Light {

	public void turnOn() {
		System.out.println("light trun on");
	}
	
	public void turnOff() {
		System.out.println("light trun off");
	}
	
	public static void main(String[] args) {
		Light light = new Light();
		RemoteControl remoteControl = new RemoteControl();
		
		Command command = new LightOnCommand(light);
		remoteControl.setCommand(command);
		remoteControl.run();
		
		command = new LightOffCommand(light);
		remoteControl.setCommand(command);
		remoteControl.run();
		remoteControl.undo();
	}
	
}
