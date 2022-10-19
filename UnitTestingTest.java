package tests;

import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
public class UnitTestingTest {
	   

	@Test
    public void test(){
        Map<String, Integer> act1 = new LinkedHashMap<>();
        act1.put("the", 56);
        act1.put("and", 30);
        act1.put("my", 24);
        act1.put("between", null);
        act1.put("Raven", 8);
        act1.put("crow", 3);
        act1.put("minute", 102);
        act1.put("ancient", 10); 

        Map<String, Integer> exp1 = new LinkedHashMap<>();
        exp1.put("ancient", 10);
        exp1.put("Raven", 8);
        exp1.put("minute", 102);
        exp1.put("the", 56);  
        exp1.put("crow", 3);
        exp1.put("my", 24);
        exp1.put("and", 30);
        exp1.put("between",null);
 
        exp1.entrySet().stream().forEach(n->System.out.println(n.getKey()));
        act1.entrySet().stream().forEach(n->System.out.println(n.getKey()));
        assertEquals(exp1, act1);
        assertTrue(act1.entrySet().equals(exp1.entrySet()));
    }
        

	@Test
	public void testAssertionRaven() {
	    String expected = "the";
	    String actual = "the";
	    assertEquals(expected, actual);
	    assertEquals("Terminate - Strings do not match!", expected, actual);
	}
	
	
	@Test
	public void testingTheRavenNULLValues() {
	    int[] expectedCode = null;
	    int[] actualCode = null;
	    assertArrayEquals(expectedCode, actualCode);
	}
	
	
	
	
	}



	  

    
    
    