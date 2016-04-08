import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException 
	{
		File fileName = new File(args[0]);
		Work work = new Work();
		work.parseFile(fileName);
		work.count();
		System.out.println("CATEGORY COUNT\n");
		work.printCount();
		System.out.println();
		work.printList();
	}
}
