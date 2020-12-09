package GNGHomeWork1;

import java.util.ArrayList;
import java.util.List;

public class PlayingDice {
	public class Dice6 {
		/**
		 * @return 1から６までの数字をらんだむで返す
		 */
		public int roll() {
			// このメソッドを完成する
			return (int)(Math.ceil(Math.random() * 6));
		}
	}
	
	/**
	 * countOfDiceの数だけダイスを投げる
	 * 
	 * @param countOfDice ダイスの数
	 * @return 各ダイス毎に数だけ結果をリストに入れて返す
	 */
	public java.util.List<Integer> testDice(int countOfDice) {
		// 内容を完成する
		// * 結果を出力する機能を作成しました
		Dice6 d = new Dice6();
		List<Integer> returnList = new ArrayList<Integer>();
		
		for(int i = 0; i < countOfDice; i++) {
			returnList.add(d.roll());
		}
		System.out.println(String.format("ダイスを%d回投げました。", countOfDice));
		
		// *
		System.out.println(" - 結果のリスト");
		System.out.println(returnList);
		System.out.println(" - 結果の分析");
		System.out.println(String.format(
				"1 : %d / %4.1f%%%n2 : %d / %4.1f%%%n3 : %d / %4.1f%%%n4 : %d / %4.1f%%%n5 : %d / %4.1f%%%n6 : %d / %4.1f%%%n", 
				countingNumber(returnList, 1), ((float)countingNumber(returnList, 1) / (float)countOfDice) * 100f,
				countingNumber(returnList, 2), ((float)countingNumber(returnList, 2) / (float)countOfDice) * 100f,
				countingNumber(returnList, 3), ((float)countingNumber(returnList, 3) / (float)countOfDice) * 100f,
				countingNumber(returnList, 4), ((float)countingNumber(returnList, 4) / (float)countOfDice) * 100f,
				countingNumber(returnList, 5), ((float)countingNumber(returnList, 5) / (float)countOfDice) * 100f,
				countingNumber(returnList, 6), ((float)countingNumber(returnList, 6) / (float)countOfDice) * 100f
				));
		// end of *
		
		return returnList;
	}
	
	// 追加で作成したメソッド
	public int countingNumber(List<Integer> list, int targetNumber) {
		int retrunCount = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == targetNumber)
				retrunCount++;
		}
		return retrunCount;
	}
}
