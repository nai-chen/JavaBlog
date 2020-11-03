package com.blog.demo.application.reference;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/*
 * https://blog.csdn.net/chennai1101/article/details/84247703
 */
public class CacheManager {

	private Map<String, SoftReference<Object>> mData = new HashMap<>();

    public Object getObject(String key) {
        SoftReference<Object> data = mData.get(key);
        if (data != null && data.get() != null) {
            return data.get();
        } else {
            return readDataFrom();
        }
    }

    private Object readDataFrom() {
        return null;
    }
    
}
