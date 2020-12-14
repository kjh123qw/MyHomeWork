package com.gngHomeWork2;

/*
 * Homework2
 * 色んな種類のダイスを投げましょう！
 */

public class DiceMain {

	/**
	 * 指定されたダイス達を順番に投げて、その合計を返す
	 * 
	 * @param diceList 投げるダイス達
	 * @return ダイスを全部投げて、その結果の合計を返す
	 * 
	 */
	private static int sumWithDices(Dice[] diceList) {
		int sum = 0;
		
		// start of my code
		for (Dice dice : diceList) {
			int number = dice.roll();
			System.out.println(String.format("%-6s: %3d", dice.getDiceName(), number));
			sum += number;
		}
		System.out.println();
		// end of my code
		
		return sum;
	}
	
	public static void main(String[] args) {
		final int result = sumWithDices(new Dice[] {
				new Dice6(), new Dice12(), new Dice4(), new Dice10()
		});
		
		System.out.println("Dice Result : " + result);
	}

}
