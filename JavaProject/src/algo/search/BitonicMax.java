package algo.search;

public class BitonicMax {
		
	int[] a;
	
	public BitonicMax(int[] copy){
		a = new int[copy.length];
		for(int i=0; i<copy.length; i++){
			a[i] = copy[i];
		}
		
	}
	
	public int search(int key){
		int lo = 0;
		int hi = a.length;
		int mid = lo + (hi-lo)/2;
		if(key < a[mid]) hi = mid - 1;
		else if(key > a[mid]) lo = mid + 1;
		else return mid;
		return -1;
	}
}