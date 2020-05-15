package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Permutation24Dian {
	static int[] number = new int[4];
	
	
	public static void main(String[] args) {
		getRandom();
		
		System.out.println(number[0]);
		System.out.println(number[1]);
		System.out.println(number[2]);
		System.out.println(number[3]);
	}
	
	static private void getRandom(){
		Random random = new Random();
		Set<Integer> tmpSet = new HashSet<Integer>();
		
		while(tmpSet.size() < 5){
			tmpSet.add(random.nextInt(10) + 1);
		}
		
		Iterator<Integer> iterator = tmpSet.iterator();
		for (int i = 0; i < number.length; i++) {
			number[i] = iterator.next();
		}
	}
}
