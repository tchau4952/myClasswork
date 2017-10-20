package arrays;

import java.util.Arrays;

public class PassByValueExamples {

	public static void main(String[] args) {
		String s = "Hello";
		Person p = new Person("Random", "Dude", Borough.NY_BOROUGHS[0]);
		int x = 5;
		int[] arr = {1,2,3};
		test3(arr);
		System.out.println("p is now "+p+", x is "+x+", arr is "+
		Arrays.toString(arr));
	}
	/**
	 * It is not possible to change an original reference via a local variable
	 * as in the example below
	 * @param p
	 * @param x
	 * @param arr
	 */
	private static void test1(Person p, int x, int[] arr) {
		String name = p.getFirstName();
		name = "Original";
		
	}
	
	/**
	 * You can change an object's references via
	 * its SETTERS (methods that set fields)
	 * @param p
	 * @param x
	 * @param arr
	 */
	private static void test2(Person p) {
		p.setFirstName("Original");
	}
	
	/**
	 * this is how you can change arrays via the local variable:
	 * through its references (i.e. indices)
	 * because primitives don't reference other data (that's why they're called primitives)
	 *  it is not possible to change them via a local variable
	 *  like we did with Objects and arrays
	 * @param arr
	 */
	private static void test3(int[] arr) {
		arr[0] = 999;
		arr[1] = 998;
	}
	
	private static void changeEVERYTHING(String s, int x, int[] array) {
		s = "Goodbye";
		x = -5;
		array = new int[5];
		array[0] = -1;
		array[1] = -2;
		
	}

}
