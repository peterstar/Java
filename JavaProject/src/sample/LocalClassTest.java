package sample;

interface Readable {
	public void read();
}

class OuterClass {
	private String myName;
	
	OuterClass(String name){
		myName = name;
	}
	
	// Access to local variable if it is final
	public Readable createLocalClassInst(final int instID) {
		class LocalClass implements Readable {
			public void read() {
				System.out.println("Outer inst name: " + myName);
				System.out.println("Outer inst name: " + instID);
			}
		}
		
		return new LocalClass();
	}
	
	// Anonymous class #1
	public Readable createAnonymousClass1Inst(final int instID){
		return new Readable(){
			public void read() {
				System.out.println("Outer inst name: " + myName);
				System.out.println("Outer inst name: " + instID);
			}
		};
	}
	
	// Anonymous class #2
	public Readable createAnonymousClass2Inst(final int instID){
		
		Readable read = new Readable(){
			public void read() {
				System.out.println("Outer inst name: " + myName);
				System.out.println("Outer inst name: " + instID);
			}
		};
		
		return read;
	}
}

class LocalClassTest {
	public static void main(String[] args) {
		OuterClass out1 = new OuterClass("first");
		Readable localInst1 = out1.createLocalClassInst(111);
		localInst1.read();
		
		OuterClass out2 = new OuterClass("second");
		Readable localInst2 = out2.createLocalClassInst(222);
		localInst2.read();
		
		OuterClass out3 = new OuterClass("third");
		Readable localInst3 = out3.createAnonymousClass1Inst(333);
		localInst3.read();
		
		OuterClass out4 = new OuterClass("fourth");
		Readable localInst4 = out4.createAnonymousClass2Inst(444);
		localInst4.read();
		
	}
}
