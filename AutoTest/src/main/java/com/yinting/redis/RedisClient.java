package com.yinting.redis;

import redis.clients.jedis.Jedis;

public class RedisClient {
	private Jedis redis;
	private static RedisClient client;
	
	
	public Jedis getRedis() {
		return redis;
	}
	private RedisClient(String server,int port,String password){
		redis=new Jedis(server, port);
		redis.auth(password);
		
	}
	public static RedisClient getInstance(String configName){
		return getInstance(System.getProperty(configName+".host"),Integer.parseInt(System.getProperty(configName+".port")),System.getProperty(configName+".password"));
	}
	public static RedisClient getInstance(String server,String password){
		return getInstance(server,6379,password);
	}
	public static RedisClient getInstance(String server,int port,String password){
		if(client == null){
			RedisClient testClient = new RedisClient(server, port, password);
			if(testClient.login()){
				client=testClient;
			}
		}
		return client;
	}
	/**
	 * 验证连接Redis是否成功
	 * */
	public boolean login(){
		return redis.isConnected();
	}
}
