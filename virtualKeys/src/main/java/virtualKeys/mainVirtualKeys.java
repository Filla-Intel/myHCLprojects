package virtualKeys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class mainVirtualKeys {

	public static void main(String[] args) {
		
		welcomeScreen();
		mainMenu();
		
		
	}
	
		//This method will loop until the user enter 0 which will break and close the program
	public static void mainMenu() {
		
		Scanner scnr = new Scanner(System.in);
		int menuOption;
		String path = "src/main/resources/";
		String fileHandle;	//name of file user enters
		int userInput;		//operation the user chooses (add/delete)
		
		do {
		System.out.println("\t\t   Main Menu\n");
		System.out.println("Enter: 1  To sort the files names in order from (A-Z)");
		System.out.println("Enter: 2  To add/ delete or search for a file name");
		System.out.println("Enter: 0  To close the application");
		System.out.println("Waiting... Please enter your selection: ");
		
		menuOption = scnr.nextInt();
		if(menuOption == 1) {
			System.out.println("Sorting files in alphebetical order:\n");
			
	        //File folder = new File("G:\\myHCLproject\\myHCLprojects\\virtualKeys\\src\\main\\resources"); works
			File folder = new File(path);
	        if(folder.isDirectory()){
	        	List<String> listFile = Arrays.asList(folder.list());
	        	Collections.sort(listFile);
	        	
	        	if (folder.list().length > 0){
				
					for(Object object:listFile)
						System.out.println(object.toString());
					
	        	}
	        	
	        }
	        else
	        	System.out.println("The directory does not exist!");
			
		}
		else if(menuOption == 2) {
			
			System.out.println("Input File Name: ");
			scnr.nextLine();
			fileHandle = scnr.nextLine();
			File file = new File(path,fileHandle);
			
			if(file.exists()) {
				try {
					System.out.println("\n\nFile Found \n" + file.getCanonicalPath() +"\n\nWould you like to delete " + fileHandle + "?");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Enter 000 to delete the following file or Enter any other key to continue: ");
				userInput = scnr.nextInt();
				if(userInput == 000) {
					file.delete();
					System.out.println("\nFile Deleted!");
				}
				else
					System.out.println("The file was not deleted");
			
			}
			else if (file.exists() == false) {
				System.out.print(fileHandle + " does not exist. Would you like to add this file? \nEnter 1 to add this file to the directory, or Enter any key to cancel: ");
				userInput = scnr.nextInt();
				if(userInput == 1) {
					try {
						file.createNewFile();
						System.out.println("\n\nFile Created!");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
					
				
			}
			
			
		}
		else if(menuOption == 0) {
			System.out.println("Saving and Closing Application. Thank you!");
			
		}
		else {
			System.out.println("Invalid User Input! Select number: 0, 1, or 2");
			
		}
		
		}while((menuOption == 1) || (menuOption == 2));
		
		scnr.close();
	}
	
	
	
	public static void welcomeScreen() {
		System.out.println("*******************************************");
		System.out.println("\t COMPANY LOCKERS Pvt. Ltd.");
		System.out.println("\nThis program will allow you to add, create, \n"  
				+ "delete, and sort differnt file types.");
		System.out.println("\t Developed by: Travis Filla");
		System.out.println("*******************************************\n\n");	
	}
	
	
}