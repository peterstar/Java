package sample;

// it is not public for one source file
abstract class PersonalNumberStorage {
	public abstract void addPersonalinfo(String name, String perNum);
	public abstract String searchName(String perNum);
}

class PersonalNumInfo {
	String name;
	String number;
	
	PersonalNumInfo(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	String getName() { return name; }
	String getNumber() { return number; }
}

class PersonalNumberStorageImpl extends PersonalNumberStorage {
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	
	public PersonalNumberStorageImpl(int size) {
		// TODO Auto-generated constructor stub
		perArr = new PersonalNumInfo[size];
		numOfPerInfo = 0;
	}
	
	@Override
	public void addPersonalinfo(String name, String perNum) {
		// TODO Auto-generated method stub
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		numOfPerInfo++;
	}
	
	@Override
	public String searchName(String perNum) {
		// TODO Auto-generated method stub
		for(int i=0; i<numOfPerInfo; i++) {
			if(perNum.compareTo(perArr[i].getNumber()) == 0)
				return perArr[i].getName();
		}
		return null;
	}
			
}

public class AbstractInterface {
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);
		storage.addPersonalinfo("kim", "1111");
		storage.addPersonalinfo("lee", "2222");
		
		System.out.println(storage.searchName("2222"));
		System.out.println(storage.searchName("1234"));
	}
}
