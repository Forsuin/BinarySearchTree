package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBSTDefaultTraversal {

	
	private  static ArrayList<Integer> defaultNumberList;
	private  static BSTree<Integer,Integer> defaultNumberTree;
	private  static BSTree<Integer,Integer> singleTestNumberTree;
	@BeforeAll
	public static void setUpAll() {
		// set of numbers to use for tree
		// use this type of setup for something you would not break by testing (like find)
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,15, 5,20, 35,30,45,65,60,70,85,95,80 ) );
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75
		 *                           15      35        65      85       
		 *                          5  20  30  45    60  70  80  95          
		 */
		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
	}
	
	@BeforeEach
	public void setUp() {
		// use this type of setup for something you would break by testing (like delete)
		// it will be reset for each test
	
		/**
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               25                75
		 *                           15      35        65      85       
		 *                          5  20  30  45    60  70  80  95          
		 */
		singleTestNumberTree = new BSTree<>();
		defaultNumberList.forEach((a) -> {singleTestNumberTree.insert(a, a);});
	}
	
	@Test
	void testInorderValues() {
		// Note This test alone does not verify the tree structure
		// But Given An Inorder traversal and Postorder Traversal we can know the structure
		// Or Given any of the following pairs:
		// Inorder and Preorder.
		// Inorder and Postorder.
		// Inorder and Level-order.
		// You need the Inorder traversal to rebuild the tree (but it is not sufficient by itself) 
		// Inorder Traversal is necessary but not sufficient
		// Secret Info: This question will be on the Final! 
		//Arrange 
		ArrayList<Integer> inorderNumberList = new ArrayList<Integer>(Arrays.asList(5, 15, 20, 25, 30, 35, 45, 50, 60, 65, 70, 75, 80, 85, 95 ) );
		// Act
		ArrayList<Integer> inorderActual = defaultNumberTree.values(BinarySearchTree.Traversal.IN_ORDER);
		// Assert
		assertEquals(inorderNumberList, inorderActual);
		
	
	}
	
	@Test
	void testPostorderValues() {
		//Arrange 
		ArrayList<Integer> inorderNumberList = new ArrayList<Integer>(Arrays.asList(5, 20, 15, 30, 45, 35, 25, 60, 70, 65, 80, 95, 85, 75, 50 ) );
		// Act
		ArrayList<Integer> inorderActual = defaultNumberTree.values(BinarySearchTree.Traversal.POST_ORDER);
		// Assert
		assertEquals(inorderNumberList, inorderActual);
		
	
	}
	@Test
	void testPreorderValues() {
		//Arrange 
		ArrayList<Integer> preOrderNumberList = new ArrayList<Integer>(Arrays.asList(50, 25, 15, 5, 20, 35, 30, 45, 75, 65, 60, 70, 85, 80, 95 ) );
		// Act
		ArrayList<Integer> preOrderActual = defaultNumberTree.values(BinarySearchTree.Traversal.PRE_ORDER);
		// Assert
		assertEquals(preOrderNumberList, preOrderActual);
		
	
	}

}
