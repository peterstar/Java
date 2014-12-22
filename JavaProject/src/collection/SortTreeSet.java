package collection;

import java.util.Iterator;
import java.util.TreeSet;

class PersonOne implements Comparable<PersonOne> {
	String name;
	int age;
	
	public PersonOne(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(PersonOne o) {
		// TODO Auto-generated method stub
		/*
		if(age > o.age) {
			return 1;
		} else if(age < o.age) {
			return -1;
		} else {
			return 0;
		}
		*/
		return age - o.age;
	}
		
	public String toString() {
		String str = name + "(" + age + ")";
		return str;
	}
}


public class SortTreeSet {
	public static void main(String[] args) {
		TreeSet<PersonOne> sTree = new TreeSet<PersonOne>();		
		sTree.add(new PersonOne("Lee", 24));
		sTree.add(new PersonOne("Hong", 29));
		sTree.add(new PersonOne("Choi", 21));
		sTree.add(new PersonOne("Yoon", 42));
		sTree.add(new PersonOne("Hong", 29));
		sTree.add(new PersonOne("Lee", 30));
		
		System.out.println("total: " + sTree.size());
		
		Iterator<PersonOne> itr = sTree.iterator();
		while(itr.hasNext()){			
			System.out.println(itr.next());
		}
		
		
	}
}