package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBSTDefaultClear {

	
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
	void testClear() {
		singleTestNumberTree.clear();
		//Arrange 
		Integer searchItem = Integer.valueOf(50);
		// Act
		Integer found = singleTestNumberTree.find(searchItem);
		// Assert

				assertAll(	() ->assertEquals(0, singleTestNumberTree.size()),
							() ->assertTrue(singleTestNumberTree.isEmpty()),
							() ->assertNull(found)				
						);	
				
		
	
	}
	
	

		
	
	


}
