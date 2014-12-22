package algo.sort;

class MergeSortOne {
	int[] numbers;
	int number;
	
	public MergeSortOne(int[] value){
		this.numbers = value;
		number = value.length;
	}
}


// Using Comparable
public class MergeSort {
	// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		// precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
		isSorted(a, lo, mid);
		isSorted(a, mid+1, hi);
		
		// copy to aux[]
		for(int i=lo; i<=hi; i++){
			aux[i] = a[i];
		}
		
		// merge back to a[]
		int i=lo, j=mid+1;
		for(int k=lo; k<=hi; k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
		// postcondition: a[lo .. hi] is sorted
		isSorted(a, lo, hi);
		
	}
	
	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(lo>=hi) return;
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);		
	}
	
	private static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
		isSorted(a);
	}
	
	// is v < w ?
	public static boolean less(Comparable v, Comparable w){
		return (v.compareTo(w) < 0);
	}
	
	public static void exch(Object[] a, int x, int y){
		Object temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static boolean isSorted(Comparable[] a, int lo, int hi){
		for(int k=lo+1; k<=hi; k++){
			if(less(a[k], a[k-1])) return false;			
		}
		return true;
		
	}
	
	public static boolean isSorted(Comparable[] a){
		return isSorted(a, 0, a.length-1);
	}
}