package sample;

public class ThreadUnderstand {
		
	public static void main(String[] args) {
		System.out.println("Extend Thread class...");
		ShowThread thread1 = new ShowThread("First Thread");
		ShowThread thread2 = new ShowThread("Second Thread");
		
		thread1.start();
		thread2.start();
		
		System.out.println("Implements Runnable...");
		AdderThread add3 = new AdderThread(1, 10);
		AdderThread add4 = new AdderThread(11, 20);

		Thread thread3 = new Thread(add3);
		Thread thread4 = new Thread(add4);
		
		thread3.start();
		thread4.start();
		
		// waits for thread3 and thread4 is completed. Then, print sum		
		try {
			thread3.join();
			thread4.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// it prints String "add3.getNum()" appends "add4.getNum()"
		//System.out.println("Sum from 1 to 20: " + add3.getNum() + add4.getNum());
		System.out.println("Sum from 1 to 20: " + (add3.getNum() + add4.getNum()));
		
		System.out.println("Heap Multi Access...");		
		Sum s = new Sum();
		
		// access to same instance
		AdderThread add5 = new AdderThread(s, 1, 10);
		AdderThread add6 = new AdderThread(s, 11, 20);
		
		Thread thread5 = new Thread(add5);
		Thread thread6 = new Thread(add6);
		
		thread5.start();
		thread6.start();
		
		try {
			thread5.join();
			thread6.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("S Sum from 1 to 20: " + s.getNum());
		
		System.out.println("Heap Multi Access by thread...");
		// access to same instance		
		AdderThreadSum addThread5 = new AdderThreadSum(s, 1, 10);
		AdderThreadSum addThread6 = new AdderThreadSum(s, 11, 20);
		
		addThread5.start();
		addThread6.start();
		
		try {
			addThread5.join();
			addThread6.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
				
		System.out.println("S Sum from 1 to 20: " + s.getNum());
	}

}

class ShowThread extends Thread {
	private String name;
	
	public ShowThread(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Thread Name: " + name);
			
			try {
				sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}			
		}		
	}	
}

class Sum {
	int num;
	boolean isSumReady = false;
	public Sum() { num = 0; }
	public void addNum(int n) {
		isSumReady = true;
		synchronized(this) { num += n; } 
	}
	public int getNum() { return num; }
	public void setNum(int n) { num = n; }
	
}

class AdderThread extends Sum implements Runnable {
	Sum sumInst = new Sum(); // if not, Null point exception occurs 
	int start, end;
	
	public AdderThread(int s, int e) {
		start = s;
		end = e;
	}
	
	public AdderThread(Sum sum, int s, int e) {
		sumInst = sum;
		start = s;
		end = e;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=start; i<=end; i++){
			addNum(i);
			sumInst.addNum(i);
		}
	}	
}

class AdderThreadSum extends Thread {
	Sum sumInst;
	int start, end;
	
	public AdderThreadSum(Sum sum, int s, int e) {
		sumInst = sum;
		start = s;
		end = e;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub				
		for(int i=start; i<=end; i++){			
			sumInst.addNum(i);
		}
	}	
}

