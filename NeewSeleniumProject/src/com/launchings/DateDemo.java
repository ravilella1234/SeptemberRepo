package com.launchings;

import java.util.Date;

public class DateDemo 
{

	public static void main(String[] args) 
	{
		Date dt=new Date();
		System.out.println(dt);
		String s = dt.toString().replace(':', '_').replace(' ', '_');
		System.out.println(s);

	}

}
