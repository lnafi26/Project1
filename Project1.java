import java.awt.Container;
import java.awt.TextArea;
import javax.swing.*;
import java.util.*;

public class Project1{
	public static void main(String[] args){
    	TextFileInput in = new TextFileInput("test.txt"); //prepares to input text file
		DateGUI dateGUI = new DateGUI(); //creates GUI where valid dates will be appended
		Container myContentPane = dateGUI.getContentPane(); //creates content pane for said GUI

		TextArea UnsortedDates = new TextArea();
		TextArea SortedDates = new TextArea(); //establishes TextAreas for unsorted and sorted dates

		myContentPane.add(UnsortedDates);
		myContentPane.add(SortedDates); //appends unsorted and sorted TextAreas to the content pane
		
		int lengthFilled = 0; //counter for date array
		String line = in.readLine(); //reads in first line of the text file
		Date212[] dates = new Date212[1000]; //establishes date array
		
		while (lengthFilled < dates.length && line != null){	
			StringTokenizer myTokens = new StringTokenizer(line,",");			
			while (myTokens.hasMoreTokens()){
				dates[lengthFilled++] = new Date212(myTokens.nextToken());
			} //ensures that each token (date) is read if they're separated by commas

			line = in.readLine(); //moves to next line
		} //reads in text file lines until the counter exceeds the length of the array

		in.close(); //closes file so my RAM doesn't grenade
		
		for (int j = 0; j < lengthFilled; j++){
			if (dates[j].isValid()) UnsortedDates.append(dates[j].toString() + "\n");
			else System.out.println("Invalid date: " + dates[j].toRaw());
		} //handles whether a date is to be appended to the GUI (valid) or printed to the console (invalid)

		for (int i = 0; i < lengthFilled - 1; i++){
	    	int indexLowest = i;
	    	for (int j = i + 1; j < lengthFilled; j++){
	        	if (dates[j].compareTo(dates[indexLowest]) == -1) indexLowest = j;
			}
	    	if (dates[indexLowest] != dates[i]) swap(dates, indexLowest, i);
		} // selectionSort, thanks DrL

		for (int j = 0; j < lengthFilled; j++){
			if (dates[j].isValid()) SortedDates.append(dates[j].toString() + "\n");
		} //appends sorted dates to the right column of the GUI
	}

	private static void swap(Date212[] arr, int a, int b){
		Date212 temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	} //swaps two dates
} //class Project1