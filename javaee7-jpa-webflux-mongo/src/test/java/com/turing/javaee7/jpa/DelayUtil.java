package com.turing.javaee7.jpa;

public class DelayUtil {
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
