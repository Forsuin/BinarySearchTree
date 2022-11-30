package itec220.labs;


import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBSTDefaultContains {

	
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
	void testInsertRoot() {
		//Arrange 
		Integer item = Integer.valueOf(50);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	
	
	@Test
	void testInsertL() {
		//Arrange 
		Integer item = Integer.valueOf(75);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
	
	}
	@Test
	void testInsertR() {
		//Arrange 
		Integer item = Integer.valueOf(25);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}

	@Test
	void testInsertR_R() {
		//Arrange 
		Integer item = Integer.valueOf(85);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	} 
	@Test
	void testInsertR_L() {
		//Arrange 
		Integer item = Integer.valueOf(65);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	
	@Test
	void testInsertL_L() {
		//Arrange 
		Integer item = Integer.valueOf(15);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
	}
	
	@Test
	void testInsertL_R() {
		//Arrange 
		Integer item = Integer.valueOf(35);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	
	@Test
	void testInsertL_L_L() {
		//Arrange 
		Integer item = Integer.valueOf(5);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
	
	}
	@Test
	void testInsertL_L_R() {
		//Arrange 
		Integer item = Integer.valueOf(20);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}

	@Test
	void testInsertL_R_L() {
		//Arrange 
		Integer item = Integer.valueOf(30);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	
	@Test
	void testInsertL_R_R() {
		//Arrange 
		Integer item = Integer.valueOf(45);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	
	@Test
	void testInsertR_R_R() {
		//Arrange 
		Integer item = Integer.valueOf(95);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	
	@Test
	void testInsertR_R_L() {
		//Arrange 
		Integer item = Integer.valueOf(80);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	@Test
	void testInsertR_L_R() {
		//Arrange 
		Integer item = Integer.valueOf(70);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	@Test
	void testInsertR_L_L() {
		//Arrange 
		Integer item = Integer.valueOf(60);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertTrue(contains);
		
	
	}
	
	@Test
	void testInsertNotInTree() {
		//Arrange 
		Integer item = Integer.valueOf(160);
		// Act
		boolean contains = defaultNumberTree.contains(item);
		// Assert
		assertFalse(contains);
		
	
	}

}
