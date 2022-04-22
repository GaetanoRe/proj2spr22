package proj2spr22;
/**
 * <p>Title: Main Class
 * <p>Description: I have 
 * @author guy
 *
 */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		ChildHeap heap = new ChildHeap();
		try {
			File in = new File("input.txt");
			Scanner scnr = new Scanner(in);
			while(scnr.hasNext()) {
				heap.insert(new Child(scnr.next(), scnr.next(), scnr.next()));
			}
			System.out.println(heap);
		}catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
