package com.aisd.euler.tests;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.utils.DebugLogger;
import com.aisd.euler.utils.NanoClock;
import com.aisd.euler.utils.StandardOutput;

public class LoggerTest {

	Logger logger;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	public LoggerTest() {
		logger = new DebugLogger(new StandardOutput(), new NanoClock());
	}
	
	@Test
	public void testCanWrite() {
		logger.setLogLevel(Logger.VERBOSE);
		String str = "Test";
		logger.write(str);
		assertTrue(outContent.toString().contains(str));
		logger.setLogLevel(Logger.DEBUG);
	}
	
	@Test
	public void testCanSliceTypes() {
		logger.setLogLevel(Logger.DEBUG);
		String str = "verboseTest";
		logger.write(str);
		assertTrue(!outContent.toString().contains(str));
		str = "debugTest";
		logger.log(Logger.DEBUG, str);
		assertTrue(outContent.toString().contains(str));
	}

}
