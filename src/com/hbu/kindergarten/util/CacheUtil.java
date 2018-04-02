package com.hbu.kindergarten.util;

import java.util.concurrent.ConcurrentHashMap;

public class CacheUtil {
	private static ConcurrentHashMap<String, Object> cache=new ConcurrentHashMap<>();
	public static Object getCache(String cacheName)
	{
		return cache.get(cacheName);
	}
	public static void putCache(String cacheName,Object object)
	{
		cache.put(cacheName, object);
	}
	public static void clean(String cacheName)
	{
		cache.put(cacheName,null);
	}
}

