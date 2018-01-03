package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ColorConverter {
	    
	    //contain main method
	    //responsible for opening and reading the data file
	    //obtaining user input
	    //perform validation and handle all errors
	    //handle exceptions from other classes and terminate gracefully
	    

	public static void main(String[] args) {
	     
	     //check if command line arguments exist
	     if (args.length < 1) {
	    	     System.err.println("ERROR: incorrect usage of command line argument.");
	    	     System.exit(1);
	     }
	     
	     
	     //create file object
	     File file = new File(args[0]);
	     //check if the file exists
	     
	    
	         //create an arraylist aka create ColorList obj
	    	 ColorList list = new ColorList();
	    
	     
	     //create scanner obj
	     Scanner scan = null;
		try {
			scan = new Scanner(file);
		} 
		
		catch (FileNotFoundException e) {
	    	     System.err.printf("ERROR: cannnot read the file %s.", args[0]);
	    	     System.exit(1);
	     }		
	     
		
	     while(scan.hasNextLine()) {
	    	     //read the next line from file
	    	     String fileLine = scan.nextLine();
	    	     //split that line at ","
	    	     if(!fileLine.isEmpty()) {
	    	     String [] currentColor = fileLine.split(",");
	    	     //trim the white space around color data
	    	     //create color object
	    	     Color c = new Color(currentColor[1].trim(), currentColor[0].trim());
	    	     list.add(c);
	    	     }
	     }
	     //System.out.println(list	);
	//close the file
	     scan.close();
	     
	    
	     
	     
	     //create true boolean
	     boolean status = true;
	     //create scanner outside while loop
		 Scanner input = new Scanner(System.in);

	     
		 while (status) {
			 //prompt the user for hexvalue
			 System.out.println("Enter a color name or the HexValue of a color in the form #XXXXXX or enter quit:");
			 //save input and make it uppercase
			 String inputColor = input.nextLine();
			 
			 
			 //if the input is quit then quit
			 if ( inputColor.equalsIgnoreCase("quit") ){
				 status = false;
				 break;
			 }
			 
			 else if ( !inputColor.equalsIgnoreCase("quit") ) {
		         //check if the inputed color is in the list
				 Color result = list.getColorByHexValue(inputColor);

				 if ( result != null)  {
					// System.out.println("Should be here");
					//if so return the color object
				 //print color obj in format 
					 System.out.printf("Color information %s", result);
				 }
				 else {
					// System.out.println("shouldn't");
					 Color newColor = new Color(inputColor);
					 System.out.printf("Color information %s", newColor);
					//create color obj using hex value
					//print output
				 } 
			 }
		 }
  }
}	
