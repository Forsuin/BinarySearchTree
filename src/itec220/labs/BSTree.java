package itec220.labs;

import static org.junit.Assert.fail;//remove once code is complete



import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("unused")
public class BSTree <Key extends Comparable<Key>, Value> implements BinarySearchTree<Key, Value>  {
	
	
	private Node root;	
	private Comparator<Key> comparator;	
	private int size = 0;

	
	public BSTree() {
		this.comparator = (k1 , k2) -> {return k1.compareTo(k2);};
	}
	
	public BSTree(Comparator<Key> comparator) {
		
		super();
		this.comparator = comparator;
	}
	
	private class Node
	{
				
		public Node(Key key, Value data) {
			// this is a leaf node
			super();			
			this.data = data;
			this.key = key;
			this.rightChild = null;
			this.leftChild = null;
		}

		 public Key key;		 
		 public Value data;		
		 public Node rightChild;		
		 public Node leftChild;
	}
	
	 
	public Value findRecursively(Key key) {
		
		fail("Not yet implemented");
		return null;
	}
	 
	private Value findIteratively(Key key) {
		
		fail("Not yet implemented");
		return null;
	}
	 
	
	@Override
	public boolean insert(Key key, Value value) {
	
		// call another method top insert
		fail("Not yet implemented");
		return false;

	}
	@Override
	public void printTree(Traversal order) {
		
	// If only I had a method that got a list of the different traversals...
	fail("Not yet implemented");
		
	}
	
	@Override
	public void clear() {
		fail("Not yet implemented");
	}
	

	public boolean isEmpty()
	{
		fail("Not yet implemented");
		return false;
	}
	@Override
	public int size() {
		fail("Not yet implemented");
		return 0;
	}

	@Override
	public boolean contains(Key key) {
		fail("Not yet implemented");		
		return false;		
	
	}

	
	public Value remove(Key key) {
		// Complete for Programming Assignment 3
		fail("Not yet implemented");
		return null;
	}
	
	@Override
	public ArrayList<Value> values(Traversal order) {
		
		fail("Not yet implemented");
		return null;
	}
	@Override
	public Value find(Key key) {
		
		fail("Not yet implemented");
		return null;
	}	
	

}
