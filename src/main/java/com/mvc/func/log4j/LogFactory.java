package com.mvc.func.log4j;

import java.util.HashMap;
import java.util.Map;

public class LogFactory {

	private static final Map<String, LogAgent> LOG_AGENT_DEFAULT = new HashMap<String, LogAgent>();
	
	private static final Map<String, LogAgent> LOG_AGENT_SPECIAL= new HashMap<String, LogAgent>();

	private LogFactory() {
	}

	public static LogAgent getLogAgent(final Class<?> aClass) {
		String name = "application";
		LogAgent logAgent = LOG_AGENT_DEFAULT.get(name);
		if (null == logAgent) {
			logAgent = new LogAgent(name);
			LOG_AGENT_DEFAULT.put(name, logAgent);
		}
		return logAgent;
	}
	
	public static LogAgent getLogAgent(final Class<?> aClass, final String logFile) {
		String name = "special";
		LogAgent logAgent = LOG_AGENT_DEFAULT.get(name);
		if (null == logAgent) {
			logAgent = new LogAgent(name, logFile);
			LOG_AGENT_SPECIAL.put(name, logAgent);
		}
		return logAgent;
	}
}
