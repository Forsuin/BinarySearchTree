package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBSTDefaultInsert {

	
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
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 0;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	
	}
	
	
	@Test
	void testInsetL() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 1;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	
	}
	@Test
	void testInsertR() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 2;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	
	}

	@Test
	void testInsertR_R() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 3;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
		
	
	} 
	@Test
	void testInsertR_L() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 4;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	
	}
	
	@Test
	void testInsertL_L() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 5;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	}
	
	@Test
	void testInsertL_R() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 6;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
		
	
	}
	
	@Test
	void testInsertL_L_L() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 7;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	
	}
	@Test
	void testInsertL_L_R() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 8;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
		
	
	}

	@Test
	void testInsertL_R_L() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 9;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	
	}
	
	@Test
	void testInsertL_R_R() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 10;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
		
	
	}
	
	@Test
	void testInsertR_R_R() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 11;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
	
	}
	
	@Test
	void testInsertR_R_L() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 12;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
		
	
	}
	@Test
	void testInsertR_L_R() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 13;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
		
	
	}
	@Test
	void testInsertR_L_L() {
		//Arrange 
		 BSTree<Integer,Integer> testTree = new BSTree<Integer,Integer>();
		 int insertbeforeTest = 14;
		 for(int i = 0; i < insertbeforeTest; i++ )
		 {
			 int insert = defaultNumberList.get(i);
			 testTree.insert(insert, insert);
		 }
		 // this is the insert we want to test!
		Integer item = defaultNumberList.get(insertbeforeTest);
		// Act
		boolean inserted = testTree.insert(item, item);
		// Assert
		assertAll(	() ->assertEquals(insertbeforeTest + 1, testTree.size()),
				() ->assertFalse(testTree.isEmpty()),
				() ->assertTrue(inserted),
				() ->assertTrue(testTree.contains(item)),
				() ->assertEquals(item, testTree.find(item))
						
			);	
		
		
	
	}
	
	
}
