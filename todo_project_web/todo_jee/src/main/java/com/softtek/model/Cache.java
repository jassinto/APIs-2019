package com.softtek.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Cache implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<Object, Object> cache = new HashMap<>();
    
	public void addToCache(Object key, Object value) {
		cache.put(key, value);
    }
	
    public Object getFromCache(Object key) {
    	return cache.get(key);
    }   
}
