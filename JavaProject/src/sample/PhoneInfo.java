package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Info<T> {
	T item;

	public void store(T item) {
		this.item = item;
	}

	public T pullOut() {
		return item;
	}
}

public class PhoneInfo implements Serializable {
	private String name;
	private String phoneNumber;

	// private String birthday;

	public PhoneInfo(String name, String ph) {
		this.name = name;
		phoneNumber = ph;
		// this.birthday = null;
	}

	// public PhoneInfo(String name, String ph, String birthday){
	// this.name = name;
	// phoneNumber = ph;
	// this.birthday = birthday;
	// }

	// public void create() {
	// System.out.println("Create PhoneInfo ");
	// System.out.println("Enter Name");
	// name = MenuViewer.keyboard.nextLine();
	// System.out.println("Enter Phone Number");
	// phoneNumber = MenuViewer.keyboard.nextLine();
	// System.out.println("Enter Birthday");
	// birthday = MenuViewer.keyboard.nextLine();
	// }

	public void show() {
		System.out.println("Name: " + name);
		System.out.println("Phone Number: " + phoneNumber);
		// if (birthday != null)
		// System.out.println("Birthday: " + birthday);
		System.out.println("");
	}

	public String getName() {
		return name;
	}

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object obj) {
		PhoneInfo pInfo = (PhoneInfo) obj;
		if (name.compareTo(pInfo.name) == 0)
			return true;
		else
			return false;
	}

}

class PhoneUnivInfo extends PhoneInfo {

	private String name;
	private String phoneNumber;
	private String major;
	private String year;

	public PhoneUnivInfo(String name, String ph, String major, String year) {
		super(name, ph);
		// TODO Auto-generated constructor stub
		this.major = major;
		this.year = year;
	}

	public void show() {
		super.show();
		System.out.println("Major: " + major);
		System.out.println("Year: " + year);
		System.out.println("");
	}

}

class PhoneCompanyInfo extends PhoneInfo {
	private String name;
	private String phoneNumber;
	private String company;

	public PhoneCompanyInfo(String name, String ph, String company) {
		super(name, ph);
		this.company = company;
	}

	public void show() {
		super.show();
		System.out.println("Company: " + company);
		System.out.println("");
	}

}

enum MenuMain {
	CREATE(1), READ(2), DELETE(3), SEARCH(4), EXIT(5), EXTRA(6);
	private int num;

	private MenuMain(int num) {
		this.num = num;
	}
};

enum MenuSelection {
	Norm, Univ, Company
};

interface Init_Menu {
	int CREATE = 1;
	int READ = 2;
	int DELETE = 3;
	int SEARCH = 4;
	int EXIT = 5;
	int EXTRA = 6;
}

interface Select_Menu {
	int NORM = 1;
	int UNIV = 2;
	int COMPANY = 3;
}

class MenuChoiceException extends Exception {
	int number;

	public MenuChoiceException(int num) {
		super("Wrong choice");
		number = num;
	}

	public void showNum() {
		System.out.println("Wrong choice: " + number);
	}
}

class PhoneBookManager {

	// public static Scanner keyboard = new Scanner(System.in);

	// public static PhoneInfo p = new PhoneInfo("", "", "");
	// public final int SIZE = 3;
	// public PhoneInfo[] pArr = new PhoneInfo[SIZE];
	// public int count = 0;

	HashSet<PhoneInfo> hSet = new HashSet<PhoneInfo>();

	// single instance
	private static PhoneBookManager pbmInst = null;

	public static PhoneBookManager getPBMInst() {
		if (pbmInst == null) {
			pbmInst = new PhoneBookManager();

		}
		return pbmInst;
	}

	private PhoneBookManager() {
		/*
		try {
			hSet = restore();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		restore();
	}

	private final File datafile = new File("phoneinfo.ser");
	
	// saving to file	
	public void saveToFile() {
		 
		try {
			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(datafile));
			Iterator<PhoneInfo> itr = hSet.iterator();
			while(itr.hasNext())
				objOutput.writeObject(itr.next());
			objOutput.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}				

	}
	// retrieving data from a file
	public void restore() {
		//HashSet<PhoneInfo> retHSet = new HashSet<PhoneInfo>();
		
		if(!datafile.exists())
			return;
		try {
			FileInputStream input = new FileInputStream(datafile);
			ObjectInputStream objInput = new ObjectInputStream(input);
			while(true){
				PhoneInfo p = (PhoneInfo) objInput.readObject();
				if(p == null)
					break;
				//retHSet.add(p);
				hSet.add(p);
			}
			objInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		
		
	}
	
	public void readData() throws MenuChoiceException {
		System.out.println("Create PhoneInfo....");
		PhoneInfo p;

		MenuViewer.showSelectMenu();
		System.out.println("Enter Selection 1 to 3: ");
		// Scanner sc = new Scanner(System.in);
		int select = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();

		if (select < 0 || select > Select_Menu.COMPANY) {
			throw new MenuChoiceException(select);
		}

		p = selPhoneInfo(select);
		
		if(p == null)
			return;
		
		boolean isAdded = hSet.add(p);
		
		saveToFile();

		
		if (isAdded)			
			System.out.println("Complete creating info....");		
		else
			System.out.println("Same name exist....");

		/*
		 * if (count < SIZE) { pArr[count] = p; count++; } else {
		 * System.out.println("No spot available...."); }
		 */

		// System.out.println("Print entered info....");
		// p.show();
		// System.out.println("count: " + count);
		//System.out.println("Complete creating info....");
	}

	private PhoneInfo selPhoneInfo(int sel) {
		PhoneInfo p = null;

		System.out.println("Enter Name");
		String name = MenuViewer.keyboard.nextLine();
		System.out.println("Enter Phone Number");
		String phoneNumber = MenuViewer.keyboard.nextLine();
		// System.out.println("Enter Birthday");
		// String birthday = MenuViewer.keyboard.nextLine();

		MenuSelection menuSelection = MenuSelection.Norm;
		
		switch (sel) {
		case Select_Menu.NORM:
			p = new PhoneInfo(name, phoneNumber);
			break;
		case Select_Menu.UNIV:
			System.out.println("Enter Major");
			String major = MenuViewer.keyboard.nextLine();
			System.out.println("Enter Year");
			String year = MenuViewer.keyboard.nextLine();
			p = new PhoneUnivInfo(name, phoneNumber, major, year);
			break;
		case Select_Menu.COMPANY:
			System.out.println("Enter Company");
			String company = MenuViewer.keyboard.nextLine();
			p = new PhoneCompanyInfo(name, phoneNumber, company);
			break;
		}

		return p;
	}

	public void showAll() {
		System.out.println("Show All PhoneInfo....");

		Iterator<PhoneInfo> itr = hSet.iterator();
		while (itr.hasNext()) {
			PhoneInfo info = itr.next();
			info.show();
		}

		/*
		 * for (int i = 0; i < count; i++) { if (pArr[i] == null) {
		 * System.out.println("Null exception "); } else { pArr[i].show(); } }
		 */

		System.out.println("Complete showing All info....");
	}

	public void deleteData() {
		System.out.println("Delete PhoneInfo....");
		System.out.println("Enter Name");
		String name = MenuViewer.keyboard.nextLine();
		// System.out.println("Deleting info....");
		
		Iterator<PhoneInfo> itr = hSet.iterator();		
		while (itr.hasNext()) {
			PhoneInfo info = itr.next();
			if (name.compareTo(info.getName()) == 0) {
				itr.remove();
				System.out.println("Complete deleting info....");
				return;
			}
		}
		/*
		 * int x = 0; if (pArr.length > 0) { x = search(name); if (x < SIZE) {
		 * // if(x == 0) { // pArr[0] = pArr[1]; // x = 1; // } for (int i = x;
		 * i < count - 1; i++) { pArr[i] = pArr[i + 1]; } count--; }
		 * 
		 * }
		 */
		//System.out.println("Complete deleting info....");
	}

	public void searchData() {
		System.out.println("Search PhoneInfo....");
		System.out.println("Enter Name");
		String name = MenuViewer.keyboard.nextLine();
		// System.out.println("Searching info....");
		// int index = SIZE;
		PhoneInfo info = search(name);
		if(info == null)
			System.out.println("No Data...: ");
		else {
			System.out.println("Data found...: \n ");			
			info.show();
		}
		
		/*
		 * if (pArr.length > 0) { search(name); } else {
		 * System.out.println("No Data...: " + pArr.length); }
		 */
		System.out.println("Complete searching info....");
		// return index;
	}

	private PhoneInfo search(String name) {
		//int index = -1;

		Iterator<PhoneInfo> itr = hSet.iterator();
		while (itr.hasNext()) {
			PhoneInfo info = itr.next();
			if (name.compareTo(info.getName()) == 0) {
				return info;
				
			}
		}

		/*
		 * for (int i = 0; i < count; i++) { if
		 * (name.compareTo(pArr[i].getName()) == 0) {
		 * System.out.println("Data found...: \n "); pArr[i].show(); index = i;
		 * } else { // System.out.println("No Data found...: " +
		 * pArr[i].getName()); // index = SIZE+1; } }
		 */
		return null;
	}
}

class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("PhoneInfo Menu");
		System.out.println("1: Create");
		System.out.println("2: Read");
		System.out.println("3: Delete");
		System.out.println("4: Search");
		System.out.println("5: Exit Menu");
		System.out.println("6: Extra...");
		System.out.println("..............");
	}

	public static void showSelectMenu() {
		System.out.println("Select PhoneInfo Menu");
		System.out.println("1: Normal Phone Info");
		System.out.println("2: University Phone Info");
		System.out.println("3: Company Phone Info");
		System.out.println("..............");
	}
}

class PhoneBook {
	public static void main(String[] args) {

		int choice = 0;
		// PhoneBookManager pbManager = new PhoneBookManager();
		PhoneBookManager pbManager = PhoneBookManager.getPBMInst();
		MenuMain menuMain = MenuMain.EXTRA;
		while (true) {
			try {
				// pbManager.menu();
				MenuViewer.showMenu();
				System.out.println("Enter choice: ");
				// Scanner sc = new Scanner(System.in);
				choice = MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();

				if (choice < 0 || choice > Init_Menu.EXTRA) {
					throw new MenuChoiceException(choice);
				}

				switch (choice) {
				case Init_Menu.CREATE:
					// p.create();
					pbManager.readData();
					break;
				case Init_Menu.READ:
					pbManager.showAll();
					// p.show();
					break;
				case Init_Menu.DELETE:
					// p.delete();
					// System.out.println("Delete PhoneInfo....");
					// System.out.println("Enter Name");
					// String search = MenuViewer.keyboard.nextLine();
					pbManager.deleteData();
					break;
				case Init_Menu.SEARCH:
					pbManager.searchData();
					break;
				case Init_Menu.EXIT:
					pbManager.saveToFile();				
					System.out.println("Exit PhoneInfo...");
					return;
				case Init_Menu.EXTRA:
					// p.update();					
					City dest = City.SEOUL;
					switch (dest) {
					case SEOUL:
						System.out.println("P: " + City.SEOUL.getPopulation());
						break;
					case DALLAS:
						System.out.println("P: " + City.DALLAS.getPopulation());
						break;
					case TOKYO:
						System.out.println("P: " + City.TOKYO.getPopulation());
						break;
					}
					break;
				}
			} catch (MenuChoiceException e) {
				e.showNum();
			}

		}

	}
}

// Enum Example
enum City {

	SEOUL(100), DALLAS(200), TOKYO(300);
	int population;

	City(int popu) {
		population = popu;
	}

	public int getPopulation() {
		return population;
	}
}
