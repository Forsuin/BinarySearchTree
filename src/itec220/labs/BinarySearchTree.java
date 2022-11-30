package itec220.labs;

import java.util.ArrayList;

public interface BinarySearchTree <Key extends Comparable<Key>, Value> {

	
	public enum Traversal {
		IN_ORDER, PRE_ORDER, POST_ORDER

	}
	
	/**
	*   @brief clear all elements from the tree.
	*
	*   @return void
	*/
	void clear();

	
	/**
	*   @brief insert the Value using the Key
	*   If the Key is already in the tree it returns false.
	*   @param  Key of the item to insert.
	*   @param  Value the item to insert.
	*   @return return true if the Value was inserted
	*/
	boolean insert(Key key, Value value);
	

	/**
	*   @brief  Get the current number of items in the tree.
	*  
	*
	*   @return int the current number of items in the tree.
	*/
	int size() ;


	/**
	*   @brief  Return true if this key is found in the tree
	*  Returns false if the Key is not found
	*  
	*   @return True if this key is in the tree 
	*/
	boolean contains(Key key);
	
	
	/**
	*   @brief  Return true if this tree has no Values
	*  
	*   @return True if the tree has no values 
	*/
	boolean isEmpty();
	
	/**
	*   @brief  Returns the value stored at with the key specified argument.
	*  Returns null if the Key is not found
	*  This method finds the item Iteratively
	*   @return Value store at this key in the tree 
	*/
	Value find(Key key) ;
		
	
	/**
	*  @brief  Return the at stored at the key
	*  Returns null if the Key is not found
	*  
	*  @return Value removed from the tree
	*/
	Value remove(Key key) ;
	
	/**
	*  @brief  prints a list 
	*  Prints "Empty Tree" if it is empty
	*  @param  Traversal indicates the order of the items: PostOrder PreOrder or InOrder.
	*/
	void printTree(Traversal order);
	
	
	/**
	*  @brief  Return an list of the  values in the tree
	*  @param  Traversal indicates the order of the items: PostOrder PreOrder or InOrder.
	*  @return a list of the  values in the tree
	*/
	ArrayList<Value> values(Traversal order);
	
	

	
	
	
}
