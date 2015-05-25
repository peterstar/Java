package algo.qa;

import java.util.Arrays;

public class IsAnagram {
	public static void main(String[] args) {
		String a = "Robin";
		String b = "binro";
		System.out.println(a + " Is Anagram " + b + "?: " + check(a, b));		
	}
	
	private static boolean checkMine(String a, String b) {
		// TODO Auto-generated method stub
		if(a.length() != b.length())
			return false;
		// sort 
		char[] aTemp = a.toLowerCase().toCharArray();
		char[] bTemp = b.toLowerCase().toCharArray();
		Arrays.sort(aTemp);
		Arrays.sort(bTemp);
		for(int i=0; i<aTemp.length; i++) {
			if(aTemp[i] != bTemp[i])
				return false;
		}
		return true;
	}
	
	private static boolean check(String a, String b) {
		if(a.length() != b.length())
			return false;
		// sort 
		a = sortString(a);
		b = sortString(b);
		// compare
		if(a.equals(b))
			return true;
		else
			return true;
	}

	private static String sortString(String temp) {
		// TODO Auto-generated method stub
		char[] arrTemp = temp.toLowerCase().toCharArray();
		Arrays.sort(arrTemp);
		return String.valueOf(arrTemp);		
	}
}