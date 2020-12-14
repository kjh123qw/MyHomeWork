package com.gngHomeWork1;

import java.util.Scanner;

/*
 * Homework1
 * ダイスを投げましょう！
 */

public class DiceMain {

	public static void main(String[] args) {
		PlayingDice pd = new PlayingDice();
		Scanner sc = new Scanner(System.in);
		String input = "";
		int countOfDice;
		
		System.out.println("プログラムをスタートします。");
		System.out.println("1から999まで数字を入力しくしてください。");
		System.out.println("修了は０です。");
		
		while(true) {
			countOfDice = -1;
			System.out.print("input >>> ");
			input = sc.nextLine();
			try {
				countOfDice = Integer.parseInt(input);
				if(countOfDice == 0) {
					break;
				} else if(0 < countOfDice && countOfDice < 1000) {
					pd.testDice(countOfDice);
				} else {
					System.out.println("  Error - 1から999まで数字を入力しくしてください。");
				}
			} catch (Exception e) {
				System.out.println("  Error - 1から999まで数字を入力しくしてください。");
			}
		}
		System.out.println("ありがとうございます。");
		sc.close();
	}

}
