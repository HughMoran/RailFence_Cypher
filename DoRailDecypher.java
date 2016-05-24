package ie.gmit.dip;

import java.util.Scanner;

public class DoRailDecypher {
	private int key;
	
	public void RailMenu() {
		Scanner s = new Scanner(System.in);

		System.out.println("*****Rail Fence Cypher*****");
		System.out.println("Enter Encrypted Code : ");
		String text = s.nextLine().toUpperCase();

		System.out.println("Enter Aproprite Key To Decypher Text: ");
		key = s.nextInt();
		if(key <=1){
			System.out.println("Enter Larger Number!!");
			System.out.println("Enter Aproprite Key To Decypher Text: ");
			key = s.nextInt();
		}

		String plainText = DoRailDecypher.DecryptRail(text, key);
		System.out.println("Decyphered Text: ");
		System.out.println(plainText);
		s.close();
	}// end of RailMenu
	

	static String DecryptRail( String text, int key){
		String[][] railFence = new String[key][text.length()];
		
		for (int i = 0; i < railFence.length; i++) {
			for (int j = 0; j < railFence[i].length; j++) {
				railFence[i][j] = ".";
				//fills the array with "."
			}
		}
		int counter = 0;
		int a = 1;
		int b = 0, c = 0;
		int inrfc = (2 * key) - 2;
		b = inrfc - 2;
		c = 2;
		for (int i = 0; i < railFence.length; i++) {
			a = 0;
			for (int j = i; j < railFence[i].length;) {
				if (counter != text.length()) {
					//iterate through the array
					if (i == 0 || i == key - 1) {
						railFence[i][j] = "" + text.charAt(counter);
						j = j + inrfc;
					}else{
						railFence[i][j] = "" + text.charAt(counter);
						if(a % 2 == 0)
							j = j + b;
						else if (a % 2 == 1)
							j = j + c;
						a++;
					}
					counter++;
				}else	
					break;
			}
			if (i != 0 && i != key - 1) {
				b = b - 2;
				c = c + 2;
			}
		}//end for loop
		//fills the array with the cypher text

		int shift = 1;
		counter = 0;
		String plainText = "";
		for (int j = 0; j < text.length(); j++) {
			if ((shift % 2)!= 0) {
				plainText = plainText + railFence[counter][j];
				if (counter == (key - 1)) {
					shift = 2;
					counter = (key - 2);
				}else
					counter ++;
			}else if ((shift % 2)== 0){
				plainText = plainText + railFence[counter][j];
				if (counter == 0) {
					shift = 1;
					counter = 1;
				}else
					counter--;
			}
		}//reads the through the array and returns the plain text
		return plainText;
	}//end DecyptRail

}//end DoRailCypher
