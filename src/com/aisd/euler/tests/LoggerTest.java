package com.aisd.euler.tests;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aisd.euler.interfaces.Logger;

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
		//logger = DaggerLoggerComponent.create().getLogger();
	}
	
	@Test
	public void testCanWrite() {
		String str = "Test";
		logger.write(str);
		assertTrue(outContent.toString().contains(str));
	}

}
