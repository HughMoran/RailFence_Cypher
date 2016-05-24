package ie.gmit.dip;

import java.io.*;
import java.util.*;

public class RailMenu {
	private String menuText = null;
	private boolean keepRunning = true;
	private Scanner s = new Scanner(System.in);
	private DoRailCypher drc = new DoRailCypher();
	private DoRailDecypher drd = new DoRailDecypher();
	private int key;

	public RailMenu() {
		super();
		this.buildMenu();

		System.out.println(menuText);

		this.getUserInput();
	}

	private void getUserInput() {
		int option = s.nextInt();
		// while(keepRunning = true){
		if (option == 1) {
			drc.RailMenu();
		} else if (option == 2) {
			try {
				drc.fileInput(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (option == 3) {
			drd.RailMenu();
		} else if (option == 4) {
			System.out.println("GOOD NIGHT!!");
			keepRunning = false;
		} else {
			System.out.println(menuText);
			System.out.println("Enter Value betweem [1-4]\n ");
			//}
		}
	}

	private void buildMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("****Rail Fence Cypher****\n ");
		sb.append("1. To Encrypt Text:\n ");
		sb.append("2. To Enter File:\n ");
		sb.append("3. To Decrypt:\n ");
		sb.append("4. To Exit programme:\n ");
		sb.append("Enter Value betweem [1-4]\n");
		menuText = sb.toString();
	}
}