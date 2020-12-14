package com.gngHomeWork2;

public class Dice4 implements Dice {
	private final String DICE_NAME = "Dice4";
	
	public String getDiceName() {
		return DICE_NAME;
	}
	
	public int roll() {
		return ((int)(Math.ceil(Math.random() * 4d)) * 2);
	}
}
