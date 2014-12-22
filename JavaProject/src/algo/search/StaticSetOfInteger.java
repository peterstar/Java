package algo.search;

import java.util.Arrays;

// The <tt>StaticSETofInts</tt> class represents a set of integers.
// It supports searching for a given integer is in the set. It accomplishes
// this by keeping the set of integers in a sorted array and using
// binary search to find the given integer.

public class StaticSetOfInteger {
	private int[] a;
	
	// check duplicate 
	public StaticSetOfInteger(int[] copy){
		
		a = new int[copy.length];
		for(int i=0; i<a.length; i++){
			a[i] = copy[i];			
		}
		
		Arrays.sort(a);
		
		for(int i=1; i<a.length; i++){
			if(a[i] == a[i-1])
				throw new IllegalArgumentException("Argument arrays contains duplicate keys.");
		}
					
	}
	
	public boolean contain(int key){
		return rank(key) != -1;
	}
	
	public int rank(int key){
		int lo = 0;
		int hi = a.length -1;
		while(lo<=hi) {
			int mid = lo + (hi-lo)/2;
			if(key < a[mid]) hi = mid - 1;
			else if(key > a[mid]) lo = mid + 1;
			else return mid;
		}		
		return -1;
	}
	
}