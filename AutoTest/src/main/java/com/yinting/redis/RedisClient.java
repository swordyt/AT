package com.yinting.redis;

import redis.clients.jedis.Jedis;

public class RedisClient {
	private Jedis redis;
	private static RedisClient client;
	
	
	private Jedis getRedis() {
		return redis;
	}
	private RedisClient(String server,int port,String password){
		redis=new Jedis(server, port);
		redis.auth(password);
		
	}
	public static Jedis getInstance(){
		return getInstance("redis_"+System.getProperty("ENV"));
	}
	
	public static Jedis getInstance(String configName){
		return getInstance(System.getProperty(configName+".host"),Integer.parseInt(System.getProperty(configName+".port")),System.getProperty(configName+".password"));
	}
	public static Jedis getInstance(String server,String password){
		return getInstance(server,6379,password);
	}
	public static Jedis getInstance(String server,int port,String password){
		if(client == null){
			RedisClient testClient = new RedisClient(server, port, password);
			if(testClient.login()){
				client=testClient;
			}
		}
		return client==null?null:client.getRedis();
	}
	/**
	 * 验证连接Redis是否成功
	 * */
	private boolean login(){
		return redis.isConnected();
	}
}
