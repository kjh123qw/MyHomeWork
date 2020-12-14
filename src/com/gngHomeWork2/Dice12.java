package com.gngHomeWork2;

public class Dice12 implements Dice {
	private final String DICE_NAME = "Dice12";
	
	public String getDiceName() {
		return DICE_NAME;
	}
	
	public int roll() {
		return (int)(Math.floor((Math.random() * -12d)));
	}
}
