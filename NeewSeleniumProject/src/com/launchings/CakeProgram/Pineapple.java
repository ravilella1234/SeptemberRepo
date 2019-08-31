package com.launchings.CakeProgram;

public class Pineapple extends Cake
{
	public Pineapple()
	{
		setName("Pine Apple");
		setType("Eggless");
		setPrice(750);
	}
	
	
	public static void main(String[] args) 
	{
		

	}

	@Override
	public void recipe() 
	{
		System.out.println("---PineApple Recipe---");
		System.out.println("Take some fresh PineApples");
		System.out.println("Wash them and Grind for 5 minutes");	
	}

	@Override
	public void myFans() 
	{
		System.out.println("PineApple lovers love me");
	}

}
