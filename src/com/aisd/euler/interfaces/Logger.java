package com.aisd.euler.interfaces;

public interface Logger {
	public static final int VERBOSE = 1337;
	public static final int INFO = 0xBAD;
	public static final int DEBUG = 0xD00D;
	public static final int WARN = 0xBADBEEF;
	public static final int ERROR = 0xD00D505;
	
	public void log(int level, String msg);
	public void write(String msg);
	public void setLogLevel(int level);
}
