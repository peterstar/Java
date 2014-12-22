package algo.sort;

import java.util.Comparator;

public class SelectionSort {
	private SelectionSort() {}
	
	// Rearranges the array in ascending order, using the natural order.
	public static void sort(Comparable[] a) {
		int min;
		int N = a.length;
		
		for(int i=0; i<N; i++){
			min = i;
			for(int j=i+1; j<N; j++){
				if(less(a[j], a[min])) min = j;				
			}
			exch(a, i, min);
		}
		
	}
	
	// Rearranges the array in ascending order, using a comparator.
	public static void sort(Comparable[] a, Comparator c){
		int N = a.length;
		for(int i=0; i<N; i++){
			int min = i;
			for(int j = i+1; j<N; j++){
				if(less(c, a[min], a[j])) min = j; 
			}
			exch(a, i, min);
		}
	}
	
	
	// is v < w
	public static boolean less(Comparable v, Comparable w){
		return (v.compareTo(w) < 0);		
	}
	
	// is v < w
	public static boolean less(Comparator c, Comparable v, Comparable w){
		return (c.compare(v, w) < 0);		
	}
	
	// exchange a[x] with a[y]
	public static void exch(Object[] a, int x, int y){
		Object temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
}