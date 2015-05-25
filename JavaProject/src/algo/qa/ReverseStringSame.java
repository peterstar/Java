package algo.qa;

// input and the reversed input are the same

public class ReverseStringSame {
	public static void main(String[] args) {
		String[] samples = new String[]{"a", "abc", "abcba", "aba", "aa", "abab", "ab"};
		System.out.println("Find same string before reverse and after reverse it: " );
		for(int i=0; i<samples.length; i++) {
			if(sameReverse(samples[i]))
				System.out.println("Same string: " + samples[i]);
		}
	}

	private static boolean sameReverse(String str) {
		// TODO Auto-generated method stub
		boolean isSame = false;
		
		// reverse string		
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		// compare it		
		String revString = sb.toString();
		System.out.println("Reverse string: " + revString);
		if(revString.equals(str))
			isSame = true;
		
		return isSame;
	}


}