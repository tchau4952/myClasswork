package arrays;

import java.util.Arrays;

public class ArraysMain {

	private int[] testArray;
	
	public ArraysMain() {
			testArray = new int[50];
			populate(testArray);
			countOccurences(testArray,2,12);
			System.out.println(Arrays.toString(testArray));
	}
	
	private void countOccurences(int[] arr, int start, int end) {
		//why create an array with this length
		int[] counter = new int[end - start + 1];
		for(int value: arr) {
			//why value - start
			counter[value - start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("The value "+(i+start)
					+" was rolled "+counter[i] + "times.");
		}
	}

	/**
	 * This method populates arr with results from rolling 2 dice
	 * @param arr
	 */
	private void populate(int[] arr) {
		//correct way:
		for(int i = 0; i < arr.length; i++) {
			arr[i] = diceRoll(2);
		}
		//incorrect way:
//		for(int value: arr) {
//			value = diceRoll(2);
//	}
	}

	public void arrayNotes() {
		//two ways to construct an array:
		int[] firstWay = {0,1,2,3,4,5};
		//this way will only work with the declaration.
		//will not work:
//		firstWay = {6,7,8,9,10};
		
		String[] secondWay = new String[5];
		//you can go on like so, creating values at each index:
		secondWay[0] = 1;
		secondWay[1] = 10;
		
		//TWO WAYS TO ITERATE THROUGH AN ARRAY:
		for(int i = 0; i < secondWay.length; i++) {
			System.out.println("The #" +i+" element is "+secondWay[i]);
		}
		//"For each int in secondWay
		for(int value: secondWay) {
			System.out.println("Element is "+value);
		}
		//NOTE: primitive arrays are autom-populated with 0s
		//Object arrays are not popular (null)
	}
	
	public static void main (String[] args) {
			ArraysMain sample = new ArraysMain();
			//1. Arrays are collections of primitives and Objects
			//SPECIAL NOTE: This is the ONLY collection of primitives
			
			//2. Size cannot be edited
			
			/* 3. Elements of an array are REFERENCES to objects. In
			* other words, changing an element of an array changes the reference,
			* not the object.
			*/
	}
		
	/**
	 * returns the result after rolling n number of dice
	 * @param n
	 * @return 
	 */
	public int diceRoll(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int dieRoll = (int)(Math.random() * 6) + 1;
			sum += dieRoll;
		}
		return sum;
	}
}
