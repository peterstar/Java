package algo.qa;

public class ReverseNumber {
	public static void main(String[] args) {
		int num = 12345;
		System.out.println("Reverse of " + num + ": " + reverseNum(num));
	}

	private static int reverseNum(int num) {
		// TODO Auto-generated method stub
		int retVal = 0;
		while(num != 0) {
			retVal = retVal * 10;
			retVal = retVal + num%10;
			num = num / 10;
		}
		
		return retVal;
	}
}