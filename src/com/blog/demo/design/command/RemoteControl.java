package com.blog.demo.design.command;

public class RemoteControl {

	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void run() {
		command.execute();
	}
	
	public void undo() {
		command.undo();
	}
	
}
