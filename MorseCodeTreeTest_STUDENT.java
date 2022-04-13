import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest_STUDENT {

	
	/**
	 * 
	 * @author Allan Kangethe
	 * 
	 * */
	MorseCodeTree theTree;

	@Before
	public void setUp() throws Exception {
		theTree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		theTree = null;
	}

	@Test
	public void fetchTest() {
		String string = theTree.fetch(".---");
		assertEquals(string, "j");

		string = theTree.fetch("--..");
		assertEquals(string, "z");
	}

	@Test
	public void toArrayListTest() {
		ArrayList<String> a = theTree.toArrayList();
		assertEquals(a.get(13), "");
		assertEquals(a.get(10), "p");
		assertEquals(a.get(20), "y");
		assertEquals(a.get(0), "h");
	}

	@Test
	public void exceptionTest() {
		try {
			theTree.update();
		}
		catch(UnsupportedOperationException e)
		{
			assertTrue("An exception was thrown", true);
		}
		
		try {
			theTree.delete("");
		}
		catch(UnsupportedOperationException e)
		{
			assertTrue("An exception was thrown", true);
		}
	}
}