package itec220.labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	
	
	public static void main(String[] args) {

		// Question 1 What is a java resource? (Use google) 
		// Question 2 What is an input stream? (Use google) 
		InputStream res = Main.class.getResourceAsStream("/files/NameList.txt");
		
		
		ArrayList<Employee> unsorted = loadEmployees(readFile(res), 1000);
		
		unsorted.forEach(System.out::println);
		
		// Question 3
		// Why am I shuffling the data? What is the deal fella?
		// What would happen if Inserted sorted data into my tree?
		Collections.shuffle(unsorted);
		
		//Check I have data that is unsorted
		//Comment out to get rid of print out
		// Once I am secure in my situation
		// Question 4 What is System.out::println
		unsorted.forEach(System.out::println);
		 		
		// Create a Binary Search Tree by calling the... 
		// Question 5 I am creating a Binary Search Tree by calling the <Insert Answer>.
		BSTree<String, Employee> bst = new BSTree<>();
		
		// use for each to add to tree		
		// because this is cool although a loop would be cool too
		// no slight against loops (since this is really a loop too)
		// check out the cool <Insert Answer> I know right.. cool 
		// Question 6 What is (employee) ->  bst.insert(employee.getID(), employee)
		// Question 7 What impact does this single line of code have?
		unsorted.forEach((employee) ->  bst.insert(employee.getID(), employee));
		
		// call print tree
		// Question 8 What is BinarySearchTree.Traversal.InOrder
		// Question 9 Where is it located
		// Question 10 Why is it located there
		bst.printTree(BinarySearchTree.Traversal.IN_ORDER);
		
		// Find an employee 
		// Use cool  <Insert Answer> IDformatter that was provided 
		// Question 11 What is Employee.IDformatter?
		// Question 12 Where is it Located and Why?
		// Question 13 What is it used for and Why is this important ?
		Employee find = bst.findRecursively(String.format(Employee.IDformatter,35));
		// Question 14 What happens when this line of code is executed?
		// Hint: how does it know what to print?
		System.out.println(find);
		// Use tree here for other exciting tasks here////
		
	}
	
	
	public static ArrayList<String> readFile(InputStream resource) {
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
			String line = "";

			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.print(" File Not found");

		} catch (IOException e) {
			e.printStackTrace();

		}
		return lines;
	}

	public static ArrayList<Employee> loadEmployees(ArrayList<String> lines, int numtoGen) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		int count = 0;
		for (int i = 0; i < numtoGen; i++) {

			String field[] = lines.get(count++).split(",");
			employees.add(new Employee(field[0], field[1], field[2], String.format("%010d", i), field[3]));
			count = count % lines.size(); 
		}

		return employees;
	}
	

	
}
