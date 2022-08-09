package testPack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lockers1 {
	
	//Menu
	public static void Menu() {
		System.out.println("\nOption 1: Show current files");
		System.out.println("\nOption 2: Interface options");
		System.out.println("\nOption 3: Close the application");
		System.out.println("\nPlease choose one of the above options");
	}
	
	//Method to choose main menu options
	public static void MainMenu() {
		File directoryPath = new File("/home/raghunandanj007/eclipse-workspace/Test/src/testPack");
		ArrayList<String> dp = new ArrayList<String>(Arrays.asList(directoryPath.list()));
		Collections.sort(dp);
		System.out.println("\nList of current files in ascending order is: \n" + dp); 
	}
	//Method to choose interface options
	public static void InterfaceMenu() {
		
		Scanner NF = new Scanner(System.in);
		System.out.println("\nChoose one of the below options");
		System.out.println("\nOption 1: Add a file to the existing directory list");
		System.out.println("\nOption 2: Delete a chosen file from the directory");
		System.out.println("\nOption 3: Search a specified file in the directory");
		System.out.println("\nOption 4: Return to the main menu");  
		int newFile = NF.nextInt();
		if(newFile==1) {
		try {
			//Add a file to the existing directory
			File myObj = new File("/home/raghunandanj007/eclipse-workspace/Test/src/testPack/Chatty.txt");

			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				System.out.println("Absolute path: " + myObj.getAbsolutePath());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
		//Delete a specified file from the directory list
		else if (newFile == 2) {
			try {
				File f = new File("/home/raghunandanj007/eclipse-workspace/Test/src/testPack/Bat");
				if (f.delete()) {
					System.out.println("The file " + f.getName() + " has been deleted");
				} else {
					System.out.println("File not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Display a specific file from the current directory
		else if (newFile == 3) {
			File directory = new File("/home/raghunandanj007/eclipse-workspace/Test/src/testPack/");
			String[] flist = directory.list();
			int flag = 0;
			if (flist == null) {
				System.out.println("\nDirectory is empty");
			} else {
				// Linear search 
				for (int i = 0; i < flist.length; i++) {
					String filename = flist[i];
					if (filename.equals("Cat")) {
						System.out.println(filename + " has been found");
						flag = 1;
					}
				}
			}
			if (flag == 0) {
				System.out.println("File Not Found");
			}

		}
		else if (newFile == 4) {
			Menu();
		}
	}
	public static void exitMethod() {
		System.out.println("\nExiting application");
		System.exit(0);
	}
	
	

	public static void main(String[] args) {
		
		//Welcome Screen
		System.out.println("Welcome to LockedMe.com");
		System.out.println("\nDeveloper Details: ");
		System.out.println("\nName: Raghunandan J");
		System.out.println("\nDesignation: Full Stack Developer");
		System.out.println("\nCompany : Lockers Pvt Ltd");
		
		Menu();
		Scanner mainMenu = new Scanner(System.in);
		int MainMenu = mainMenu.nextInt();

		if (MainMenu == 1) {
			MainMenu();
		}
		else if(MainMenu == 2){
			InterfaceMenu();
		}
		else if(MainMenu == 3){
			exitMethod();
		}
	}
}
