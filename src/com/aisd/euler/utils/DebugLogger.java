package com.aisd.euler.utils;

import javax.inject.Inject;

import com.aisd.euler.interfaces.IClock;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.interfaces.OutputStream;

public class DebugLogger implements Logger {
	private OutputStream stream;
	private IClock clock;
	private int level;

	@Inject
	public DebugLogger(OutputStream stream, IClock clock) {
		this.stream = stream;
		this.clock = clock;
		this.level = DEBUG;
	}

	@Override
	public void log(int level, String msg) {
		if (this.level > level)
			return;
		char lvlChar;
		switch (level) {
		case INFO:
			lvlChar = 'I';
			break;
		case DEBUG:
			lvlChar = 'D';
			break;
		case WARN:
			lvlChar = 'W';
			break;
		case ERROR:
			lvlChar = 'E';
			break;
		default:
			lvlChar = 'V';
			break;
		}
		stream.writeToStream(String.format("%c/ %d\t%s", lvlChar, clock.time(),
				msg));
	}

	@Override
	public void write(String msg) {
		log(VERBOSE, msg);
	}

	@Override
	public void setLogLevel(int level) {
		this.level = level;
	}

}
