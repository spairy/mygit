package com.mvc.func.log4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LogAgent {

	private final Logger log;

	private static final Properties properties;

	static {
		try {
			properties = new Properties();
			InputStream inputStream = LogAgent.class.getClassLoader().getResourceAsStream("config\\Configuration.properties");
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public LogAgent(final String className) {
		log = Logger.getLogger(className);
		addDailyRollingFileAppender(properties.getProperty("conf.default.log.path"));
	}

	public LogAgent(final String className, final String logFile) {
		log = Logger.getLogger(className);
		addDailyRollingFileAppender(logFile);
	}

	private void addDailyRollingFileAppender(final String logFile) {
		try {
			DailyMaxRollingFileAppender dailyMaxRollingFileAppender = null;
			PatternLayout patternLayout = new PatternLayout();
			patternLayout.setConversionPattern("[%-5p]-[%d{yyyy-MM-dd HH:mm:ss,SSS}] %l %m%n");
			dailyMaxRollingFileAppender = new DailyMaxRollingFileAppender(patternLayout, logFile, "'.'yyyy-MM-dd");
			dailyMaxRollingFileAppender.setMaxBackupIndex(20);
			dailyMaxRollingFileAppender.setThreshold(Level.DEBUG);
			log.addAppender(dailyMaxRollingFileAppender);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public void debug(final String message) {
		StringBuffer msg = new StringBuffer(100);
		msg.append(message);
		log.log(Level.DEBUG, msg.toString());
	}

	public void debug(final String message, final Throwable throwable) {
		StringBuffer msg = new StringBuffer(100);
		msg.append(message);
		log.log(Level.DEBUG, msg.toString(), throwable);
	}

	public void info(final String message) {
		StringBuffer msg = new StringBuffer(100);
		msg.append(message);
		log.log(Level.INFO, msg.toString());
	}

	public void info(final String message, final Throwable throwable) {
		StringBuffer msg = new StringBuffer(100);
		msg.append(message);
		log.log(Level.INFO, msg.toString(), throwable);
	}

	public void error(final String message) {
		StringBuffer msg = new StringBuffer(100);
		msg.append(message);
		log.log(Level.ERROR, msg.toString());
	}

	public void error(final String message, final Throwable throwable) {
		StringBuffer msg = new StringBuffer(100);
		msg.append(message);
		log.log(Level.ERROR, msg.toString(), throwable);
	}
}
