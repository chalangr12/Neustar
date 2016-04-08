import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class WorkTest {

	/**
	 * Test Case: Test Null. No File.
	 * 
	 * null
	 * 
	 * @throws IOException
	 */
	@Test
	public void testNull() throws IOException {
		Work work = new Work();
		work.parseFile(null);
		work.count();
		assertTrue(work.getAnimal()== 0);
		assertTrue(work.getComputer() == 0);
		assertTrue(work.getOther() == 0);
		assertTrue(work.getPlace() == 0);
		assertTrue(work.getPlace() == 0);
		
	}
	
	/**
	 * Test Case: Test an empty file, 
	 * 			  literally, there is nothing in there
	 * 
	 * 
	 * 
	 * @throws IOException
	 */
	@Test
	public void testEmptyFile() throws IOException{
		String line = "emptyFile.txt";
		File fileName = new File(line);
		Work work = new Work();
		work.parseFile(fileName);
		work.count();
		assertTrue(work.getAnimal()== 0);
		assertTrue(work.getComputer() == 0);
		assertTrue(work.getOther() == 0);
		assertTrue(work.getPlace() == 0);
		assertTrue(work.getPerson() == 0);
	}
	/**
	 * Test Case: Invalid Categories
	 * 
	 *	PEOPLE Ben Affleck
	 *	PHONES Iphone
	 *	COMPINC Corsair
	 *	BATTERIES Duracel
	 *
	 * @throws IOException
	 */
	@Test
	public void testBadCategories() throws IOException{
		String line = "badCategories.txt";
		File fileName = new File(line);
		Work work = new Work();
		work.parseFile(fileName);
		work.count();
		assertTrue(work.getAnimal()== 0);
		assertTrue(work.getComputer() == 0);
		assertTrue(work.getOther() == 0);
		assertTrue(work.getPerson() == 0);
		assertTrue(work.getPlace() == 0);
	}
	
	/**
	 * Test Case: One Valid Category
	 * 
	 * PEOPLE Ben Affleck
	 * PHONES Iphone
	 * COMPINC Corsair
	 * BATTERIES Duracel
	 * ANIMAL CAT
	 * 
	 * @throws IOException
	 */
	@Test
	public void testOneValidCategory() throws IOException{
		String line = "OneValidCategory.txt";
		File fileName = new File(line);
		Work work = new Work();
		work.parseFile(fileName);
		work.count();
		assertTrue(work.getAnimal()== 1);
		assertTrue(work.getComputer() == 0);
		assertTrue(work.getOther() == 0);
		assertTrue(work.getPlace() == 0);
		assertTrue(work.getPerson() == 0);
	}
	
	@Test
	public void testAllValidCategory() throws IOException{
		String line = "allValidCategories.txt";
		File fileName = new File(line);
		Work work = new Work();
		work.parseFile(fileName);
		work.count();
		assertTrue(work.getAnimal()== 1);
		assertTrue(work.getComputer() == 1);
		assertTrue(work.getOther() == 1);
		assertTrue(work.getPlace() == 1);
		assertTrue(work.getPerson() == 1);
	}
}
