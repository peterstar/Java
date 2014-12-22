package sample;

import java.util.Random;

public class ThreadFiveInputs {
	public static void main(String[] args) {
		// pass 5 inputs to a thread
		IntegerComm comm = new IntegerComm();
		IntegerSum sum = new IntegerSum(comm);
		sum.start();
		
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int x = random.nextInt(5);
			comm.setNum(x);
			//comm.setNum(i);
			System.out.print(x + " ");
		}
		System.out.println();
						
		try {
			sum.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class IntegerComm {
	int num = 0;
	boolean isNewNumber = false;
	
	public void setNum(int n) {
		synchronized(this) {
			if(isNewNumber == true) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			num = n;
			isNewNumber = true;
			notify();
		}
	}
	
	public int getNum() {
		int retnum = 0;
		synchronized (this) {
			if(isNewNumber == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			retnum = num;
			isNewNumber = false;
			notify();
		}
		return retnum;
	}
	
}

class IntegerSum extends Thread {
	IntegerComm commInst = new IntegerComm();
	int sum;
	
	public IntegerSum(IntegerComm comm){
		commInst = comm;
	}

	public void run() {
		for(int i=0; i<5; i++){
			sum += commInst.getNum();
		}
		System.out.println("Sum: " + sum);
	}	
}