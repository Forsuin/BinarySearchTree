package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestBinarySearchTreePrintOut {

	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	// this will be called before every test
	@BeforeEach
	public void setUp() {
		 // set output of standard print to outputStreamCaptor
		 System.setOut(new PrintStream(outputStreamCaptor));
	}
	// this will be called before every test
	@AfterEach
	public void tearDown() {
		//reset standard out
	    System.setOut(standardOut);
	}
	
	@Test
	void test() {
		String expected = "Yes I can Unit Test Prinouts";
		System.out.print("Yes I can Unit Test Prinouts");
	        
		    assertEquals(expected, outputStreamCaptor.toString()
		      .trim());
	}
}
