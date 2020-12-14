package com.gngHomeWork2;

public class Dice6 implements Dice {
	private final String DICE_NAME = "Dice6";
	
	public String getDiceName() {
		return DICE_NAME;
	}
	
	public int roll() {
		return (int)(Math.ceil(Math.random() * 6d));
	}
}
