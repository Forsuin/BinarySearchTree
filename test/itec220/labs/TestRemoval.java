package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import itec220.labs.BinarySearchTree.Traversal;

class TestBSTRemove {

	private static ArrayList<Integer> defaultNumberList;
	private static BSTree<Integer, Integer> defaultNumberTree;
	private static BSTree<Integer, Integer> singleTestNumberTree;
	
	
	@BeforeAll
	public static void setupAll()  {
		// set of numbers to use for tree
		// use this type of setup for something you would not break by testing (like find)
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(44, 22, 55, 8, 34, 49, 58, 5, 33, 40, 45, 54, 56) );
		/**
		 *Tree inserted in this order should look like:
		 *                                        44
		 *                               22                55
		 *                            8      34        49      58       
		 *                          5      33  40    45  54  56            
		 */
		defaultNumberTree = new BSTree<Integer,Integer>();
		defaultNumberList.forEach((a) -> {defaultNumberTree.insert(a, a);});
	}
	
	@BeforeEach
	public void setUp() {
		// use this type of setup for something you would break by testing (like delete)
		// it will be reset for each test
	
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(44, 22, 55, 8, 34, 49, 58, 5, 33, 40, 45, 54, 56) );

		
		/**
		 *Tree inserted in this order should look like:
		 *                                        44
		 *                               22                55
		 *                            8      34        49      58       
		 *                          5      33  40    45  54  56            
		 */
		singleTestNumberTree = new BSTree<>();
		defaultNumberList.forEach((a) -> {singleTestNumberTree.insert(a, a);});
	}
	
	@Test
	void removeLeftMostLeaf() {
		//Arrange
		Integer removed = singleTestNumberTree.remove(5);
		
		//Act
		ArrayList<Integer> testList = defaultNumberList;
		testList.remove(7);
		
		//Assert
		assertAll(() -> assertEquals(defaultNumberList.size(), singleTestNumberTree.size()),
				  () -> assertFalse(singleTestNumberTree.isEmpty()),
				  () -> assertEquals(testList, singleTestNumberTree.values(Traversal.LEVEL_ORDER)),
				  () -> assertEquals(5, removed),
				  () -> assertFalse(singleTestNumberTree.contains(5))
				  );
		
	}
	
	@Test
	void removeRightMostLeaf() {
		Integer removed = singleTestNumberTree.remove(56);
		
		ArrayList<Integer> testList = defaultNumberList;
		testList.remove(testList.size() - 1);
		
		assertAll(() -> assertEquals(defaultNumberList.size(), singleTestNumberTree.size(), "Size: "),
				  () -> assertFalse(singleTestNumberTree.isEmpty()),
				  () -> assertEquals(testList, singleTestNumberTree.values(Traversal.LEVEL_ORDER)),
				  () -> assertEquals(56, removed, "Removed: "),
				  () -> assertFalse(singleTestNumberTree.contains(56), "Contains Element: ")
				  );
	}
	
	@Test
	void removeRoot() {
		int fullSize = singleTestNumberTree.size();
		
		Integer removed = singleTestNumberTree.remove(44);
		ArrayList<Integer> testList = defaultNumberList;
		testList.set(0, 45);
		testList.remove(10);
		
		
		assertAll(() -> assertEquals(fullSize - 1, singleTestNumberTree.size(), "Size: "),
				  () -> assertFalse(singleTestNumberTree.isEmpty()),
				  () -> assertEquals(testList, singleTestNumberTree.values(Traversal.LEVEL_ORDER)),
				  () -> assertEquals(44, removed, "Removed Element Equals: "),
				  () -> assertFalse(singleTestNumberTree.contains(44), "Contains element: ")
				);
	}
	
	@Test 
	void removeEmptyTree() {
		singleTestNumberTree.clear();
		
		Integer removed = singleTestNumberTree.remove(56);
		
		assertAll(() -> assertEquals(0, singleTestNumberTree.size()),
				  () -> assertTrue(singleTestNumberTree.isEmpty()),
				  () -> assertEquals(null, removed),
				  () -> assertFalse(singleTestNumberTree.contains(56))
				);
	}
	
	
	@Test
	void removeLastNode() {
		singleTestNumberTree.clear();
		
		singleTestNumberTree.insert(1, 1);
		
		Integer removed = singleTestNumberTree.remove(1);
		
		assertAll(() -> assertEquals(0, singleTestNumberTree.size(), "Size: "),
				  () -> assertTrue(singleTestNumberTree.isEmpty(), "IsEmpty: "),
				  () -> assertEquals(1, removed, "Removed element: "),
				  () -> assertFalse(singleTestNumberTree.contains(1), "Contains: ")
				);
	}

}