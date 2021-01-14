package com.gngHomeWork4;

import com.gngHomeWork3.NumberGenerator100;

public class BingoChecker {
	
	private byte[][] board5x5;
	
	public BingoChecker(byte[][] board5x5) { this.board5x5 = board5x5; }
	
	public void PrintBoard() {
		System.out.println();
		System.out.println("===============");
		System.out.println("=[BINGO BOARD]=");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(String.format("%3d", board5x5[i][j]));
			}
			System.out.println();
		}
		System.out.println("===============");
	}
	
	/**
	 * 今回呼ばれた数字で、ビンゴが完成したのかを確認する
	 * 
	 * @param calledNum 今回呼ばれた数字
	 * @return ビンゴが完成したら「true」を返す
	 */
	public boolean checkBingo(byte calledNum) {
		boolean returnValue = false;
		
//		ビンゴボードでバン後を探す：探したら0で変更
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board5x5[i][j] == calledNum) board5x5[i][j] = 0;
			}
		}
		
//		横、縦、対角線の中で合計が0になったらビンゴ！
		for (int i = 0; i < 5; i++) {
			int sumHor = 0;
			int sumVer = 0;
			int sumDia1 = 0;
			int sumDia2 = 0;
			for (int j = 0; j < 5; j++) {
				sumHor += board5x5[i][j];
				sumVer += board5x5[j][i];
				if(i == 0) sumDia1 += board5x5[j][j];
				if(i == 0) sumDia2 += board5x5[4-j][j];
			}
			if(sumHor == 0 || sumVer == 0 || (i == 0 && (sumDia1 == 0 || sumDia2 == 0))) {
				returnValue = true;
				break;
			}
		}
		
		return returnValue;
	}
	
	public static void main(String[] args) {
		final byte[][] sampleBoard = new byte[][] {
			new byte[] {97,12, 8,14, 2},
			new byte[] {33,98,87,66,91},
			new byte[] {23,85,10,30,54},
			new byte[] {34,38,42,50,46},
			new byte[] {95,56,63,92,21}
		};
		final BingoChecker checker = new BingoChecker(sampleBoard);
		
		final NumberGenerator100 numGen = new NumberGenerator100();
		for (int i = 0; i < 100; i++) {
			final byte called = numGen.generate('A');
			
			if (i % 10 == 0) System.out.println();
			System.out.print(String.format("%3d", called));
			
			if (checker.checkBingo(called)) {
				System.out.println();
				checker.PrintBoard();
				System.out.println("\nBingo!");
				break;
			}
		}
	}

}
