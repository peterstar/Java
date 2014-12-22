package algo.sort;

// Insertion sort with index h for quicker sort
public class ShellSort {
	
	public static void sort(Comparable[] a){
		int N = a.length;
		
		// 3x+1 increment sequence:
		int h = 1;
		while(h < N/3) {
			h = h*3 + 1;
			while(h >= 1) {
				for(int i=h; i<N; i++){
					for(int j=i; j>=h && less(a[j], a[j-h]); j-=h){
						exch(a, j, j-h);
					}
				}
				h = h/3;
			}
			
		}
		
	}
	
	public static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);		
	}
	
	public static void exch(Object[] a, int x, int y){
		Object temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
}