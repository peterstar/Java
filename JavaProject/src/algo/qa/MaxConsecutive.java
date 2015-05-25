package algo.qa;

// find a number of consecutive - which number is maximum consecutive
// 123, 123, 12, 1234 Then 4 is the answer

public class MaxConsecutive {
	public static void main(String[] args) {
		System.out.println("find maximum consecutive: ");
		int[] samples = new int[] { 123, 123, 12, 1234 };
		int max = 0;
		max = maxConsecutive(samples);
		System.out.println("Max Consecutive number " + max);	
		
	}

	private static int maxConsecutive(int[] num) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}