package com.gngHomeWork2;

public class Dice10 implements Dice {
	private final String DICE_NAME = "Dice10";
	
	public String getDiceName() {
		return DICE_NAME;
	}
	
	public int roll() {
		return (int)(Math.ceil(Math.random() * 9d) * 10d);
	}
}
