package com.blog.demo.design.singleton;

public class Singleton4 {
	public enum SingletonHandler {
        handler;
	
        private Singleton4 singleton;
        private SingletonHandler() {
            singleton = new Singleton4();
        }

        public Singleton4 getSingleton() {
            return singleton;
        }
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return SingletonHandler.handler.getSingleton();
    }
}
