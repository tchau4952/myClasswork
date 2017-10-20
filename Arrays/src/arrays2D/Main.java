package arrays2D;

public class Main {

	public static void Main(String[] args) {
		Array2DSampler test = new Array2DSampler();
	}
	
	/**
	 * PRECONDITION: i >= 0 and i < arr.length
	 * increases the element at i by 1
	 * decreases the element at i -1 and i + 1, if they exist
	 * AVOIDS ArrayIndexOutofBoundsException
	 * THIS IS SUCH A HEAVILY TESTED CONCEPT,
	 * on every exam, you should always be in the habit of checking for
	 * ArrayIndexOutOfBoundsExceptions
	 * Trust me, don't be "that guy" who lost a bazillion points
	 * @param arr
	 * @param i
	 */
	private static void changeNeighbors(int[] arr, int i) {
		arr[i]++;
		if(i - 1 >= 0) {
			arr[i-1]--;
		}
		if(i + 1 >= 0) {
			arr[i + 1]++;
		}
	}

}
