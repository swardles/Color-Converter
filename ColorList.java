package project2;

public class ColorList extends OrderedLinkedList<Color> {
		
		Color c;
	
		public ColorList() {
		//default constructor
			
			super();
		}
		
		public Color getColorByName (String colorName) {
		//returns the Color object in the list whose color name matches the colorName the user inputed.
		//This method is case insensitive. If inputed colorName doesn't exist, return value is null.
			
			colorName = colorName.toUpperCase().replaceAll("\\s", "");
	
			for ( int i = 0; i < this.size(); i++) {
				if (colorName.equals(this.get(i).getName())) {
					c = this.get(i);
					return c;
				}
			}
			return null;
		}
		
		public Color getColorByHexValue (String colorHexValue) {
		//returns the Color object in the list whose color hex value matches the colorHexValue the user inputed.
		//this method is case insensitive. 
			
			colorHexValue = colorHexValue.toUpperCase();
			
			for ( int i = 0; i < this.size(); i++) {
				if (colorHexValue.equals(this.get(i).getHexValue())) {
					c = this.get(i);
					return c;
				}		
			}
			return null;
		}
}