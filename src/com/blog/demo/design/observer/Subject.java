package com.blog.demo.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements Observable {

	private List<Observer> observerList = new ArrayList<>();
	private String subject;
	
	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
		notifyObserver();
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observerList) {
			observer.onChanged(subject);
		}
	}

}
