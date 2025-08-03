package com.turing.javaee7.jpa;

public class DealyUtil {
	public static void delay(long ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
