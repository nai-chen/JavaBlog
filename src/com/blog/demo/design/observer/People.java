package com.blog.demo.design.observer;

public class People implements Observer {
	
	private String name;
	
	public People(String name) {
		this.name = name;
	}

	@Override
	public void onChanged(String subject) {
		System.out.println(name + " receive new subject: " + subject);
	}

	public static void main(String[] args) {
		Subject subject = new Subject();
		
		People jack = new People("Jack");
		subject.addObserver(jack);
		
		People mike = new People("Mike");
		subject.addObserver(mike);
		
		People lily = new People("Lily");
		subject.addObserver(lily);
		
		subject.setSubject("subject1");
		subject.setSubject("subject2");		
	}
	
}
