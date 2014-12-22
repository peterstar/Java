package collection;

import java.util.HashSet;
import java.util.Iterator;

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + "(" + age + ")";
	}
	
	public int hashCode() {
		return name.hashCode() + age%7;
	}
	
	public boolean equals(Object obj) {
		Person comp = (Person)obj;
		if((name.compareTo(comp.name) == 0) /* comp.age == age */ )
			return true;
		else
			return false;
	}
	
}

public class HashSetEqulity {
	public static void main(String[] args) {
		HashSet<Person> hSet = new HashSet<Person>();
		hSet.add(new Person("kim", 10));
		hSet.add(new Person("kim", 20));
		hSet.add(new Person("lee", 20));
		hSet.add(new Person("lee", 15));
		hSet.add(new Person("lee", 20));
		hSet.add(new Person("kim", 20));
		
		System.out.println("total: " + hSet.size());
		
		Iterator<Person> itr = hSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}
}