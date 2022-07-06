
//Karim Atalla
//Comp 482 MW 3:30
//Project 2
//Prof Noga
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project2 {

	public static void main(String[] args) {

		ArrayList<Location> list_elements = new ArrayList<>(); // arraylist of locations
		int element = 0;
		try {
			// open the specified file for reading inside a try catch
			Scanner inputfile = new Scanner(new File("input2.txt"));
			// this loop will read until end of file and add locations into an arraylist
			// structure
			while (inputfile.hasNextInt()) {
				list_elements.add(new Location());
				list_elements.get(element).first = inputfile.nextInt();
				list_elements.get(element).second = inputfile.nextInt();
				element++;
			}
			inputfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Location.l1(list_elements);// calls l1 metric
		Location.l2(list_elements);// calls l2 metric
		
	}// main
}// Project2