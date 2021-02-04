package emailValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;


public class ValidEmail {
	
	public static void main(String[] args) {
		final int arraySize = 10;
		Path path = FileSystems.getDefault().getPath("src/emailValidation/emailList.txt").toAbsolutePath();
		//String fileName = "G:\\myEclipseProjects\\emailValidation\\bin\\emailList.txt";
		String[] emails = new String[arraySize];
		int i,j = 0;
		
		for(i = 0; i < arraySize; i++)
			emails[i] = "null";
		
		//System.out.println(emails[9]);
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a Valid Email Address: ");
		String userInput = scnr.nextLine();
		
		try {
            FileReader reader = new FileReader(path.toFile());
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
            	emails[j] = line;
                j++;
                if(j==arraySize)
                	break;
            }
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		for(i=0; i < arraySize; i++) {
			if(emails[i].compareTo(userInput)==0)
			{
				System.out.print("Email Found: " + emails[i]);
				break;
				
			}
			else
			{
				if(i==arraySize-1)
					System.out.print("Email " + userInput + " NOT Found!");
				
			}
		}
		//System.out.println(emails[0]);
        //System.out.println(emails[1]);
        //System.out.println(emails[2]);
		
		
		
	}

}
