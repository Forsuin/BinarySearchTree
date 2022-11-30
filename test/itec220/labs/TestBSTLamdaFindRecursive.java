package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBSTLamdaFindRecursive {

	
	private  static ArrayList<Integer> defaultNumberList;
	private  static BSTree<String,Employee> defaultEmployeeTree;
	private  static BSTree<String,Employee> singleTestEmployeeTree;
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		defaultNumberList = new ArrayList<Integer>(Arrays.asList(50,25,75,15, 5,20, 35,30,45,65,60,70,85,95,80 ) );
		
		int typeCount = EmployeeType.values().length;
		defaultEmployeeTree = new BSTree<String, Employee>(( s1 , s2) -> s2.compareTo(s1));
		for(Integer i : defaultNumberList)
		{
			String id = String.format("%010d", i);
			defaultEmployeeTree.insert(id,new Employee("First"+i, "Last"+i, EmployeeType.values()[i % typeCount].text ,id, ""+i));
		}
			
		/**50,25,75,15, 5,20, 35,30,45,65,60,70,85,95,80
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               75                25
		 *                           85      65        35      15       
		 *                         95  80  70  60    45  30  20   5          
		 */
	}
	@BeforeEach
	public void setUp() {
		// use this type of setup for something you would break by testing (like delete)
		// it will be reset for each test
	
		int typeCount = EmployeeType.values().length;
		singleTestEmployeeTree = new BSTree<String, Employee>(( s1 , s2) -> s2.compareTo(s1));
		for(Integer i : defaultNumberList)
		{
			String id = String.format(Employee.IDformatter, i);
			singleTestEmployeeTree.insert(id,new Employee("First"+i, "Last"+i, EmployeeType.values()[i % typeCount].text ,id, ""+i));
		}
			
		/**50,25,75,15, 5,20, 35,30,45,65,60,70,85,95,80
		 *Tree inserted in this order should look like:
		 *                                        50
		 *                               75                25
		 *                           85      65        35      15       
		 *                         95  80  70  60    45  30  20   5          
		 */
	}
	@Test
	void testFindRoot() {
		int num = 50;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
	
	}
	
	
	@Test
	void testFindL() {
		int num = 75;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	@Test
	void testFindR() {
		int num = 25;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
	
	}

	@Test
	void testFindR_R() {
		int num = 15;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	@Test
	void testFindR_L() {
		int num = 35;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	
	@Test
	void testFindL_L() {
		int num = 85;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	
	@Test
	void testFindL_R() {
		int num = 65;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	
	@Test
	void testFindL_L_L() {
		int num = 95;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	@Test
	void testFindL_L_R() {
		int num = 80;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}

	@Test
	void testFindL_R_L() {
		int num = 70;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	
	@Test
	void testFindL_R_R() {
		int num = 60;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	
	@Test
	void testFindR_R_R() {
		int num = 5;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
	
	}
	
	@Test
	void testFindR_R_L() {
		int num = 20;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	@Test
	void testFindR_L_R() {
		int num = 30;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
	
	}
	@Test
	void testFindR_L_L() {
		int num = 45;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertAll(() ->assertEquals(searchItem, found.getID()),
				
				() ->assertEquals("First"+num, found.getFirstName()),
				() ->assertEquals("Last"+num, found.getLastName()),
				() ->assertEquals(""+num, found.getLevel()),
				() ->assertEquals(searchItem, found.getID())				
				);	
		
	
	}
	@Test
	void testFindNotInTree() {
		int num = 145;
		//Arrange 
		String searchItem = String.format(Employee.IDformatter, num);
		// Act
		Employee found = defaultEmployeeTree.findRecursively(searchItem);
		// Assert
		assertNull(found);
		
	
	}

}
