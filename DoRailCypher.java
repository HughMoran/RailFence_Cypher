package ie.gmit.dip;

import java.io.*;
import java.util.*;

public class DoRailCypher {
	private int key;

	public static void main(String[] args) {
		new DoRailCypher();
	}

	public void RailMenu() {
		Scanner s = new Scanner(System.in);

		System.out.println("*****Rail Fence Cypher*****");
		System.out.println("Enter Text: ");
		String text = s.nextLine().toUpperCase().trim();

		System.out.println("Enter Key Number [2-10]: ");
		key = s.nextInt();
		if (key <= 1) {
			System.out.println("Enter Larger Number!!");
			System.out.println("Enter Key Number [2-10]: ");
			key = s.nextInt();
		}//if loop

		String result = DoRailCypher.doCypher(key, text);
		System.out.println("Cypher Text: ");
		System.out.println(result);
		
	}// end of RailMenu

	static String fileInput(int key) throws IOException {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter Source of the required file: ");
		String fileText = read.nextLine();
		FileReader file = new FileReader(fileText);
		BufferedReader reader = new BufferedReader(file);
		String text = "";
		String line = reader.readLine();
		System.out.println("Enter key number [2-10]");
		key = read.nextInt();
		if(key <= 1){
			System.out.println("Enter Larger Number!!");
			System.out.println("Enter Key Number [2-10]: ");
			key = read.nextInt();
		}

		while (line != null) {
			text += line;
			line = reader.readLine();

		}
		String result = DoRailCypher.doCypher(key, text);
		System.out.println("Encrypted File: ");
		System.out.println(result);
		return null;
	}//end fileInput

	static String doCypher(int key, String text) {

		int counter = 0;
		int shift = 1;
		String[][] railFence = new String[key][text.length()];

		for (int x = 0; x < railFence.length; x++) {
			for (int y = 0; y < railFence[x].length; y++) {
				railFence[x][y] = ".";
				// fills the array table full of "."
			}
		}
		for (int i = 0; i < text.length(); i++) {
			if ((shift % 2) != 0) {
				railFence[counter][i] = "" + text.charAt(i);
				if (counter == (key - 1)) {
					shift = 2;
					counter = (key - 2);
				} else
					counter++;
			} else if ((shift % 2) == 0) {
				railFence[counter][i] = "" + text.charAt(i);
				if (counter == 0) {
					shift = 1;
					counter = 1;
				} else
					counter--;
			}//loops through the array and add char to "i"
		}
		for (int x = 0; x < railFence.length; x++) {
			for (int y = 0; y < railFence[x].length; y++) {
				if (railFence[x][y].equals(" ")) {
					railFence[x][y] = "X";// adds X for a space
				}
			}
		}
		for (int i = 0; i < railFence.length; i++) {
			for (int j = 0; j < railFence[i].length; j++) {
				System.out.print(railFence[i][j] + " ");
			}
			// displays the array with text and "."
			System.out.println();
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < railFence.length; i++) {
			for (int j = 0; j < railFence[i].length; j++) {
				if (!".".equals(railFence[i][j])) {
					sb.append(railFence[i][j]);
					// append encrypted text to stringbuffer
				}
			}
		}
		// returns the stringbuffer to the menu above to print cypher text
		return "" + sb;
	}// end doCypher
}// end DoRailcypher
