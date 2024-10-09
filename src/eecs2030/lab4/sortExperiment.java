package eecs2030.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sortExperiment {
	private static Random rng = new Random();

	public static void main(String[] args) {
		List <Integer> list;
		long start, end;

		//You might need to change the 1M value to something smaller for other sorts
		for (int i = 10000; i <= 1_000_000; i *= 10){ 
			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.defaultSort(list);
			end = System.nanoTime();
			System.out.println("N=" + i + "\nTime spent: " + (end - start)/1e6 + " ms");
		}
	}

	private static List <Integer> createRandomList (int size){
		rng.setSeed(8);
		List <Integer> list = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			list.add(rng.nextInt());
		}
		return list;
	}


}
