package algo.sort;

import java.util.Comparator;

// sort for partially sorted (such as insert card) 
public class InsertionSort {
	
	public static void sort(Object[] a, Comparator c){
		int N = a.length;
		for(int i=0; i<N; i++){
			for(int j=i; j>0 && less(c, a[j], a[j-1]); j--){
				exch(a, j, j-1);
			}
		}
	}
	
	public static boolean less(Comparator c, Object v, Object w){
		return (c.compare(v, w) < 0);
	}
	
	public static void exch(Object[] a, int x, int y){
		Object temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}