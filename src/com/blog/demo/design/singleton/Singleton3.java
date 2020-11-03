package com.blog.demo.design.singleton;

import java.io.Serializable;

public class Singleton3 implements Serializable {

	private static final long serialVersionUID = 5438745590438707250L;

	private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return SingletonHandler.INSTANCE;
    }

    private static class SingletonHandler {
        private static Singleton3 INSTANCE = new Singleton3();
    }
    
    private Object readResolve() {
    	return SingletonHandler.INSTANCE;
    }
}
