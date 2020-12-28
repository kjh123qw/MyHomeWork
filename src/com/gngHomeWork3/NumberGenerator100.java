package com.gngHomeWork3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator100 {
	List<Byte> solAHundredList = new ArrayList<Byte>();
	List<Byte> solBHundredList = new ArrayList<Byte>();
	List<Byte> solCHundredList = new ArrayList<Byte>();
	
	public NumberGenerator100() {
		super();
		// Solution A Collections 使用
		for (byte i = 1; i <= 100; i++)
			solAHundredList.add(i);
		Collections.shuffle(solAHundredList);
		
		// Solution B
		for (byte i = 1; i <= 100; i++) {
			solBHundredList.add((byte)Math.floor(Math.random() * i), i);
		}
		
		// Solution C
		for (byte i = 1; i <= 100; i++)
			solCHundredList.add(i);
		for (byte i = 1; i <= 100; i++) {
			solCHundredList.remove(solCHundredList.indexOf(i));
			solCHundredList.add((byte)(Math.floor(Math.random() * 99)), i);
		}
	}
	
	/**
	 * 1～100の間の数をランダムに返す。
	 * 但し、返す数には重複はない。
	 * つまり、100回実行すると1から100の数が全部で一つづて返されたことになる。
	 * 
	 * @return 1~100の数。但し、もう返す数う数字がない場合は「０」を返す。
	 * @param A, B, Cのソルーションを選択する。
	 */
	public byte generate(char selectSolution) {
		byte returnValue = 0;
		if(selectSolution == 'A') {
			if(!solAHundredList.isEmpty()) {
				returnValue = solAHundredList.get(0);
				solAHundredList.remove(0);
			}
		} else if(selectSolution == 'B') {
			if(!solBHundredList.isEmpty()) {
				returnValue = solBHundredList.get(0);
				solBHundredList.remove(0);
			}
		} else if(selectSolution == 'C') {
			if(!solCHundredList.isEmpty()) {
				returnValue = solCHundredList.get(0);
				solCHundredList.remove(0);
			}
		} else {
			System.out.println("NumberGenerator100.generate(\"Wrong parameter\")");
		}
		return returnValue;
	}
	
	// main()のコードは変更しないでください。
	public static void main(String[] args) {
		final NumberGenerator100 numGen = new NumberGenerator100();
		
		// Solution A Test
		System.out.println("Solution A Test");
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0 && i != 0) System.out.println();
			System.out.print(String.format("%3d ", numGen.generate('A')));
		}
		// Solution A Test: isEmpty
		System.out.println("\nCheck Empty ==> " + numGen.generate('A'));
		System.out.println();
		
		
		// Solution B Test
		System.out.println("Solution B Test");
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0  && i != 0) System.out.println();
			System.out.print(String.format("%3d ", numGen.generate('B')));
		}
		// Solution B Test: isEmpty
		System.out.println("\nCheck Empty ==> " + numGen.generate('B'));
		System.out.println();
		
		
		// Solution C Test
		System.out.println("Solution C Test");
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0  && i != 0) System.out.println();
			System.out.print(String.format("%3d ", numGen.generate('C')));
		}
		// Solution C Test: isEmpty
		System.out.println("\nCheck Empty ==> " + numGen.generate('C'));
		System.out.println();
	}

}
