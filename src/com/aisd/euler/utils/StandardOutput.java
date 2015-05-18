package com.aisd.euler.utils;

import com.aisd.euler.interfaces.OutputStream;

public class StandardOutput implements OutputStream{
	
	@Override
	public void writeToStream(String data) {
		System.out.println(data);		
	}
	

}
