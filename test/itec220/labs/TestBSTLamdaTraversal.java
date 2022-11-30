package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBSTLamdaTraversal {

	
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
		ArrayList<Integer> inOrderNumberList = new ArrayList<Integer>(Arrays.asList(95, 85, 80, 75, 70, 65, 60, 50, 45, 35, 30, 25, 20, 15, 5 ) );
		// Act
		ArrayList<Employee> employees = defaultEmployeeTree.values(BinarySearchTree.Traversal.IN_ORDER);
		ArrayList<Integer> actualList = new ArrayList<Integer>();
		employees.forEach((e)-> actualList.add(Integer.parseInt(e.getID()) ));
		// Assert
		assertEquals(inOrderNumberList, actualList);
		
	
	}
	
	@Test
	void testPostorderValues() {
		//Arrange 
		ArrayList<Integer> postOrderNumberList = new ArrayList<Integer>(Arrays.asList(95, 80, 85, 70, 60, 65, 75, 45, 30, 35, 20, 5, 15, 25, 50 ) );
		// Act
		ArrayList<Employee> employees = defaultEmployeeTree.values(BinarySearchTree.Traversal.POST_ORDER);
		ArrayList<Integer> actualList = new ArrayList<Integer>();
		employees.forEach((e)-> actualList.add(Integer.parseInt(e.getID()) ));
		// Assert
		assertEquals(postOrderNumberList, actualList);
		
	
	}
	@Test
	void testPreorderValues() {
		//Arrange 
		ArrayList<Integer> preOrderNumberList = new ArrayList<Integer>(Arrays.asList(50, 75, 85, 95, 80, 65, 70, 60, 25, 35, 45, 30, 15, 20, 5 ) );
		// Act
		ArrayList<Employee> employees = defaultEmployeeTree.values(BinarySearchTree.Traversal.PRE_ORDER);
		ArrayList<Integer> actualList = new ArrayList<Integer>();
		employees.forEach((e)-> actualList.add(Integer.parseInt(e.getID()) ));
		// Assert
		assertEquals(preOrderNumberList, actualList);
		
	
	}

}
