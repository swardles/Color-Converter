package project2;

public class Color implements Comparable<Color> {

//color class stores information about a particular color

//instance variables
//instance variables are the variables that are declared in a class but not 
// in a method, they are used in the methods
	
private String colorHexValue;  //hex value
private String colorName;  // color name
private int red;  //red value
private int blue;  //green value
private int green;  //blue value

//constructors
public Color ( String colorHexValue ){
	  //check to see if coloHexValue is written in the correct format of #XXXXXX
	  
    //validate parameter within the constructor
	  char firstIndex = colorHexValue.charAt(0);
	  
	  if ( firstIndex == '#' && colorHexValue.length() == 7 ) {
		  String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		  for(int i = 1; i < colorHexValue.length(); i++) {
			  String currentIndex = Character.toString(colorHexValue.charAt(i));
			  if(!validChars.contains(currentIndex)){
				  throw new IllegalArgumentException("ERROR: you entered an incorrect hexvalue."); 
			  }
		  }
		  
	      this.colorHexValue = colorHexValue;
	      hexToDec(colorHexValue);
	  }
	  else {
		  //throw and error
		  System.err.println("ERROR: you entered an incorrect hexvalue.");
	  }
	  
}
public Color ( String colorHexValue, String colorName ){
	  //validate parameter within the constructor
	  char firstIndex = colorHexValue.charAt(0);

	  if ( firstIndex == '#' && colorHexValue.length() == 7 ) {
		  String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		  
		  for(int i = 1; i < colorHexValue.length(); i++) {
			  String currentIndex = Character.toString(colorHexValue.charAt(i));
			  if(!validChars.contains(currentIndex)){
				  throw new IllegalArgumentException("ERROR: you entered an incorrect hexvalue."); 
			  }
		  }
		  
		
	      this.colorHexValue = colorHexValue;
	      hexToDec(colorHexValue);
	  }
	  else {
		  //throw and error
		  throw new IllegalArgumentException("ERROR: you entered an incorrect hexvalue.");
	  }
	  
    this.colorName = colorName;
}
public Color ( int red, int green, int blue ){
	  
	  //check to make sure the values for red blue and green are between 0 and 255 inclusively
	  if (red >= 0 && red <= 255) {
		  this.red = red;
	  }
	  if (green >= 0 && green <= 255) {
		  this.green = green;
	  }
	  if (blue >= 0 && blue <= 255) {
		  this.blue = blue;
	  }
    
}

//accessor methods
public int getRed(){return red;} //returns value of red component

public int getGreen(){return green;} //returns value of green component

public int getBlue(){return blue;} //returns value of blue component

public String getName(){return colorName;} //returns the value of the color
// or null if there is no name associated with this Color object

public String getHexValue(){return colorHexValue;} //returns the hexadecimal
//representation of the Color object in format #XXXXXX


//utility methods for actually doing things  

@Override
public String toString() {
    return colorHexValue + " (" + red + "," + green + "," + blue + ") " + colorName +"\n";
}

@Override
public int compareTo(Color obj) {
	return(this.colorHexValue.compareToIgnoreCase(obj.colorHexValue));
}

//equals method
@Override
public boolean equals(Object obj) {
	if (this == obj) //are they pointers to the same thing/obj
		return true;
	if (obj == null) //undefined or not pointing to anything
		return false;
	if (getClass() != obj.getClass())//inherited method from obj class compares classes
		return false;
	Color other = (Color) obj; //casting obj to color class
	if (colorHexValue == null) {
		if (other.colorHexValue != null)
			return false;
	} else if (!colorHexValue.equalsIgnoreCase(other.colorHexValue))
		return false;
	return true;
}

  //converts the hex to decimal 
  public void hexToDec( String colorHexValue) {
  	    red = Integer.parseInt(colorHexValue.substring(1,3), 16);
  	    green = Integer.parseInt(colorHexValue.substring(3,5), 16);
  	    blue = Integer.parseInt(colorHexValue.substring(5,7), 16);
  	    //return "(" + redValue + "," + greenValue + "," + blueValue + ")" ;
  }
  //converts from rgb value to hex
  public void decToHex(int red, int green, int blue) {
  	    String result = "" + red + green + blue;   	
      	int num = Integer.parseInt(result);
      String returnedHex = Integer.toHexString(num);
      //return "#" + returnedHex;
  }
}