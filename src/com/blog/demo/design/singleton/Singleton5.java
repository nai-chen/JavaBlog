package com.blog.demo.design.singleton;

public class Singleton5 {
	
	private static Singleton5 INSTANCE;
    private Singleton5() {
    }
    static {
        INSTANCE = new Singleton5();
    }
    
    public static Singleton5 getInstance() {
        return INSTANCE;
    }
    
}
