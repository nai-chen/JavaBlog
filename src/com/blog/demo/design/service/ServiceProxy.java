package com.blog.demo.design.service;

public class ServiceProxy implements IService {
	private IService service;
	
	public ServiceProxy(IService service) {
		this.service = service;
	}

	@Override
	public String sayHello() {
		System.out.println("before sayHello");
		String value = service.sayHello();
		System.out.println("after sayHello");
		return value;
	}
	
	public static void main(String[] args) {
		IService service = new ServiceProxy(new MyService());
		System.out.println(service.sayHello());
	}

}
