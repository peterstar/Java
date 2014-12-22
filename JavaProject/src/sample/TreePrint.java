package sample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Relation {
	String parent;
	String child;

	public Relation(String parent, String child) {
		this.parent = parent;
		this.child = child;
	}
}

class RelationComparator implements Comparator<Relation> {
	@Override
	public int compare(Relation arg0, Relation arg1) {
		// TODO Auto-generated method stub		
		return arg0.child.compareTo(arg1.child);
	}	
}

class BNode {

	public BNode leftBNode, rightBNode; // the nodes
	public Relation anyClass; // the AnyClass objext

	public BNode(Relation anyClass) {// constructor
		this.anyClass = anyClass;
		this.leftBNode = null;
		this.rightBNode = null;
	}

	public void show() {
		// calls the show method of the AnyClass
		System.out.println(anyClass.parent);
		System.out.println(anyClass.child);		
	}
}

class BinTree {
	BNode theBTRootNode;

	public BinTree() // constructor
	{
		theBTRootNode = null;
	}

	// ------------------ Addition of the node to the BST-------------------
	protected BNode insertAB(BNode theRootNode, BNode myNewNode) {
		if (theRootNode == null) {
			theRootNode = myNewNode;
			// checks if the username is smaller than
			// the root object, if smaller appends to the left
		} else if (myNewNode.anyClass.parent
				.compareTo(theRootNode.anyClass.parent) < 0) {
			theRootNode.leftBNode = insertAB(theRootNode.leftBNode, myNewNode);
		} else {
			// else if bigger appends to the right
			theRootNode.rightBNode = insertAB(theRootNode.rightBNode, myNewNode);
		}
		return theRootNode;
	}

	public void insertBST(Relation anyClass) {
		BNode anyClassBTNode = new BNode(anyClass);
		// calls insert above
		theBTRootNode = insertAB(theBTRootNode, anyClassBTNode);
	}

	// ------------------ InOrder traversal-------------------
	protected void inorder(BNode theRootNode) {
		if (theRootNode != null) {
			inorder(theRootNode.leftBNode);
			theRootNode.show();
			inorder(theRootNode.rightBNode);
		}
	}

	// calls the method to do in order
	public void inorderBST() {
		inorder(theBTRootNode);
	}
	
	// ------------------ InOrder traversal-------------------
	protected void preorder(BNode theRootNode) {
		if (theRootNode != null) {
			theRootNode.show();
			preorder(theRootNode.leftBNode);			
			preorder(theRootNode.rightBNode);
		}
	}

	// calls the method to do in order
	public void preorderBST() {
		preorder(theBTRootNode);
	}
	

	// ----- Search for key name and returns ref.
	// to BNode or null if not found--------
	protected BNode search(BNode theRootNode, String keyName) {
		// if the root is null returns null
		if (theRootNode == null) {
			return null;
		} else {
			// checks if they are equal
			if (keyName.compareTo(theRootNode.anyClass.parent) == 0) {
				return theRootNode;
				// checks id the key is smaller than the current
				// record if smaller traverses to the left
			} else if (keyName.compareTo(theRootNode.anyClass.parent) < 0) {
				return search(theRootNode.leftBNode, keyName);
			} else {
				// if bigger traverses to the left
				return search(theRootNode.rightBNode, keyName);
			}
		}
	}

	// returns null if no result else returns
	// the AnyClass object matched with the keyName
	public Relation searchBST(String keyName) {
		BNode temp = search(theBTRootNode, keyName);
		if (temp == null) {
			// noresults found
			return null;
		} else {
			// result found
			return temp.anyClass;
		}
	}

	public void populateBinTree(List theList) {
		// clearing the root as not to append,
		// if you want to append just remove the below line
		theBTRootNode = null;
		// keeps looping until reaches the end of the list
		for (int i = 0; i < theList.size(); i++) {
			// Node temporaryNode = null;
			// inserts in the BST
			insertBST((Relation) theList.get(i));
			// goes to the next element
		}
	}
}



public class TreePrint {
	public static void main(String[] args) {
		List<Relation> input = new ArrayList<Relation>();
		input.add(new Relation("animal", "mammal"));
		input.add(new Relation("animal", "bird"));
		input.add(new Relation("lifeform", "animal"));
		input.add(new Relation("cat", "lion"));
		input.add(new Relation("mammal", "cat"));
		input.add(new Relation("animal", "fish"));

		TreePrint t = new TreePrint();
		t.printTree(input);
	}
	
	public void printTree(List<Relation> input) {
		BinTree bTree = new BinTree();
		bTree.populateBinTree(input);
		//bTree.inorderBST();
		bTree.preorderBST();
	}

}

// Using HashMap
class TreePrinter {
	
	public static void main(String[] args) {
		List<Relation> input = new ArrayList<Relation>();
		input.add(new Relation("animal","mammal"));
		input.add(new Relation("animal","bird"));
		input.add(new Relation("lifeform","animal"));
		input.add(new Relation("cat","lion"));
		input.add(new Relation("mammal","cat"));
		input.add(new Relation("animal","fish"));
		
		TreePrinter t = new TreePrinter();
		t.printTree(input);
	}
	
	public void printTree(Iterable<Relation> rs){
		
		//build a tree like below with lifeform as root 
		//and do a traversal.
		//lifeform -- animal
		//animal -- mammal -- cat-- lion
		//animal -- bird
		//animal -- fish
		
		//use this set to keep track of children to find out 
		//which one is the root node.
		Set<String> setOfNotRootElements = new HashSet<String>();
		
		//build a tree using HashMap. You can also build the tree 
		//put a Map inside a Map, but this seems simpler.
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(Relation r: rs){
			List<String> children =  new ArrayList<String>();
			if(map.containsKey(r.parent)){
				children = map.get(r.parent);
			}
			children.add(r.child);
			map.put(r.parent, children );
			
			//keeping track of children..
			setOfNotRootElements.add(r.child);
		}
		
		//find the root
		Set<String> diffSet = new HashSet<String>(map.keySet());
		diffSet.removeAll(setOfNotRootElements);
		String root = diffSet.iterator().next();
		
		//traverse the tree.
		printNode(root, map);
		
		//lifeform
		//animal
		//mammal
		//cat
		//lion
		//bird
		//fish
	}
	
	public void printNode(String parent, HashMap<String, List<String>> map){
		System.out.println(parent);
		List<String> children = map.get(parent);
		if(children != null){
			for(String child: children){
				printNode(child, map);
			}
		}
	}
 
}