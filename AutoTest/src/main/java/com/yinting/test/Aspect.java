package com.yinting.test;

import java.lang.reflect.Parameter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Properties;

import org.apache.http.util.Args;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;

@Intercepts({ 
	@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})
})
public class Aspect implements Interceptor {
//	org.mybatis.spring.SqlSessionFactoryBean
	public Object intercept(Invocation invocation) throws Throwable {
		Connection conn=(Connection)invocation.getArgs()[0];
//		conn.get
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		System.out.println(target.toString());
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
//		org.mybatis.spring.SqlSessionFactoryBean
		System.out.println("这里是监控！");
	}
	// public void intercept(JoinPoint point) {
	// System.out.println("这是监控！");
	// System.out.println(point.METHOD_CALL);
	// }
}
