package com.yinting.core;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

public class Log {
	private static final Logger log = Logger.getLogger(Log.class);

	private Log(String name) {
		
	}

	public static Logger instance() {
		PropertyConfigurator.configure("config/log4j.properties");
		return log;
	}

	public static synchronized void addAppender(Appender newAppender) {
		// TODO Auto-generated method stub
		Log.instance().addAppender(newAppender);
	}

	public static void assertLog(boolean assertion, String msg) {
		// TODO Auto-generated method stub
		Log.instance().assertLog(assertion, msg);
	}

	public static void callAppenders(LoggingEvent event) {
		// TODO Auto-generated method stub
		Log.instance().callAppenders(event);
	}

	public static void debug(Object message) {
		// TODO Auto-generated method stub
		Log.instance().debug(message);
	}

	public static void debug(Object message, Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().debug(message, t);
	}

	public static void error(Object message) {
		// TODO Auto-generated method stub
		Log.instance().error(message);
	}

	public static void error(Object message, Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().error(message, t);
	}

	public static void fatal(Object message) {
		// TODO Auto-generated method stub
		Log.instance().fatal(message);
	}

	public static void fatal(Object message, Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().fatal(message, t);
	}

	public static boolean getAdditivity() {
		// TODO Auto-generated method stub
		return Log.instance().getAdditivity();
	}

	public static synchronized Enumeration getAllAppenders() {
		// TODO Auto-generated method stub
		return Log.instance().getAllAppenders();
	}

	public static synchronized Appender getAppender(String name) {
		// TODO Auto-generated method stub
		return Log.instance().getAppender(name);
	}

	public static Level getEffectiveLevel() {
		// TODO Auto-generated method stub
		return Log.instance().getEffectiveLevel();
	}

	public static Priority getChainedPriority() {
		// TODO Auto-generated method stub
		return Log.instance().getChainedPriority();
	}

	public static LoggerRepository getHierarchy() {
		// TODO Auto-generated method stub
		return Log.instance().getHierarchy();
	}

	public static LoggerRepository getLoggerRepository() {
		// TODO Auto-generated method stub
		return Log.instance().getLoggerRepository();
	}

	public static ResourceBundle getResourceBundle() {
		// TODO Auto-generated method stub
		return Log.instance().getResourceBundle();
	}

	public static void info(Object message) {
		// TODO Auto-generated method stub
		Log.instance().info(message);
	}

	public static void info(Object message, Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().info(message, t);
	}

	public static boolean isAttached(Appender appender) {
		// TODO Auto-generated method stub
		return Log.instance().isAttached(appender);
	}

	public static boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return Log.instance().isDebugEnabled();
	}

	public static boolean isEnabledFor(Priority level) {
		// TODO Auto-generated method stub
		return Log.instance().isEnabledFor(level);
	}

	public static boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return Log.instance().isInfoEnabled();
	}

	public static void l7dlog(Priority priority, String key, Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().l7dlog(priority, key, t);
	}

	public static void l7dlog(Priority priority, String key, Object[] params,
			Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().l7dlog(priority, key, params, t);
	}

	public static void log(Priority priority, Object message, Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().log(priority, message, t);
	}

	public static void log(Priority priority, Object message) {
		// TODO Auto-generated method stub
		Log.instance().log(priority, message);
	}

	public static void log(String callerFQCN, Priority level, Object message,
			Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().log(callerFQCN, level, message, t);
	}

	public static synchronized void removeAllAppenders() {
		// TODO Auto-generated method stub
		Log.instance().removeAllAppenders();
	}

	public static synchronized void removeAppender(Appender appender) {
		// TODO Auto-generated method stub
		Log.instance().removeAppender(appender);
	}

	public static synchronized void removeAppender(String name) {
		// TODO Auto-generated method stub
		Log.instance().removeAppender(name);
	}

	public static void setAdditivity(boolean additive) {
		// TODO Auto-generated method stub
		Log.instance().setAdditivity(additive);
	}

	public static void setLevel(Level level) {
		// TODO Auto-generated method stub
		Log.instance().setLevel(level);
	}

	public static void setPriority(Priority priority) {
		// TODO Auto-generated method stub
		Log.instance().setPriority(priority);
	}

	public static void setResourceBundle(ResourceBundle bundle) {
		// TODO Auto-generated method stub
		Log.instance().setResourceBundle(bundle);
	}

	public static void warn(Object message) {
		// TODO Auto-generated method stub
		Log.instance().warn(message);
	}

	public static void warn(Object message, Throwable t) {
		// TODO Auto-generated method stub
		Log.instance().warn(message, t);
	}
}
