package com.gngHomeWork3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator100 {
	List<Byte> hundredList = new ArrayList<Byte>();
	
	public NumberGenerator100() {
		super();
		// Collections 使用
		for (byte i = 1; i <= 100; i++)
			hundredList.add(i);
		Collections.shuffle(hundredList);
		
		// Customize 1
//		for (byte i = 1; i <= 100; i++) {
//			hundredList.add((byte)Math.floor(Math.random() * i), i);
//		}
	}
	
	/**
	 * 1～100の間の数をランダムに返す。
	 * 但し、返す数には重複はない。
	 * つまり、100回実行すると1から100の数が全部で一つづて返されたことになる。
	 * 
	 * @return 1~100の数。但し、もう返す数う数字がない場合は「０」を返す。
	 */
	public byte generate() {
		byte returnValue = 0;
		if(!hundredList.isEmpty()) {
			returnValue = hundredList.get(0);
			hundredList.remove(0);
		}
		return returnValue;
	}
	
	// main()のコードは変更しないでください。
	public static void main(String[] args) {
		// Test
		final NumberGenerator100 numGen = new NumberGenerator100();
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0 ) System.out.println();
			System.out.print(String.format("%3d ", numGen.generate()));
		}
		
		// Test: isEmpty
		System.out.println("\nCheck Empty ==> " + numGen.generate());
	}

}
