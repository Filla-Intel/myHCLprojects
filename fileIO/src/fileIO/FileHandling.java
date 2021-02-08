package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;


/*This will read an .csv file the first column A is the day, B is month, C is year
 * Column D is team number either 1 or 2, E stands for morning what task was completed
 * during that time (1/2/3), F is afternoon task, and G is the evening task. 
 *
 * 
 */

public class FileHandling {

	private static final Path path = FileSystems.getDefault().getPath("src/fileIO/test.csv").toAbsolutePath();
	
	public static void main(String[] args) {
		
		getLine();
		printData();
		enterNewData();
		
	
	}

public static void getLine() {
	
	String line = "";
	
	
	try {
		BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
		
		while((line = br.readLine()) != null) {
			
			if(line.equals(",,,,,,,,,,,,,,,")) {
				break;
			}
			//System.out.println(line);
			
			dataRecord(line, -1);
			
			
			
		
		}	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
}
	
	
	
	

static int[] teamData1 = new int [15];
static int[] teamData2 = new int [15];
public static void dataRecord(String importLine, int num) {
	int numberPlusOne = num+1;
	
	if((num > -1) && (teamData1[3] == 1))
	{
		System.out.println("Team:" + numberPlusOne + " has a total of: " + teamData1[num] + " completed");
		
	}
	else if((num > -1) && (teamData2[3] == 2))
	{
		System.out.println("Team:" + numberPlusOne + " has a total of: " + teamData1[num] + " completed");
		
	}
	else {
		String[] ColValues = new String[7];
		
		ColValues = importLine.split(",");
		if(Integer.parseInt(ColValues[3]) == 1) {
			teamData1[0] = Integer.parseInt(ColValues[0]);
			teamData1[1] = Integer.parseInt(ColValues[1]);
			teamData1[2] = Integer.parseInt(ColValues[2]);
			teamData1[3] = Integer.parseInt(ColValues[3]);
			
			
			for(int colNum = 4; colNum < 7; colNum++) {
				for(int taskNum = 0; taskNum < 12; taskNum++)
					if(Integer.parseInt(ColValues[colNum]) == taskNum+1)
						teamData1[taskNum+4] = teamData1[taskNum+4] + 1;
							
			}
		}
		else if(Integer.parseInt(ColValues[3])== 2) {
	
			teamData2[0] = Integer.parseInt(ColValues[0]);
			teamData2[1] = Integer.parseInt(ColValues[1]);
			teamData2[2] = Integer.parseInt(ColValues[2]);
			teamData2[3] = Integer.parseInt(ColValues[3]);
			
			
			for(int colNum = 4; colNum < 7; colNum++) {
				for(int taskNum = 0; taskNum < 12; taskNum++)
					if(Integer.parseInt(ColValues[colNum]) == taskNum+1)
						teamData2[taskNum+4] = teamData2[taskNum+4] + 1;
							
			}
		}
	
	
	}
	


}

public static void printData() {
	
	int totalT1 = 0, totalT2 = 0;
	
	for(int k= 0; k<11;k++) {
		totalT1 = totalT1 + teamData1[k+4];
		totalT2 = totalT2 + teamData2[k+4];
		
	}
	
		System.out.println("Team 1 has completed: " + totalT1 + " Total Tasks this week");
		System.out.println("Team 2 has completed: " + totalT2 + " Total Tasks this week");

	
}
	

public static void enterNewData() {
	int month, day, year, teamNum, taskTypeA, taskTypeB, taskTypeC;
	int addToFile = 0;
	
	Scanner scnr = new Scanner(System.in);
	
	System.out.println("Enter num 1 if you would like to add a new entry to the file. Enter anything else to continue w/o appending");
	addToFile = scnr.nextInt();
	if(addToFile == 1) {
	System.out.println("Enter the month");
	month = scnr.nextInt();
	System.out.println("Enter the day");
	day = scnr.nextInt();
	System.out.println("Enter the year '4 digit'");
	year = scnr.nextInt();
	System.out.println("Enter the Team Number '1or2'");
	teamNum = scnr.nextInt();
	System.out.println("Enter what task was completed in the morning '1,2,or3'");
	taskTypeA = scnr.nextInt();
	System.out.println("Enter what task was completed in the afternoon '1,2,or3'");
	taskTypeB = scnr.nextInt();
	System.out.println("Enter what task was completed in the evening '1,2,or3'");
	taskTypeC = scnr.nextInt();
	
	try {
		FileWriter fw = new FileWriter(path.toFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		//System.out.println(pw);
		
		pw.println(month + ","+ day + ","+  year + ","+ teamNum + ","+  taskTypeA + ","+  taskTypeB + ","+  taskTypeC);
		pw.flush(); //ensures all data is written to the file
		pw.close();
		System.out.println("Record Saved");
		//JOptionPane.showMessageDialog(null, "Record saved");
		
	}catch(Exception E) {
		System.out.println("Record NOT Saved File maybe opened");
		//JOptionPane.showMessageDialog(null, "NOT Record saved");
		
	}
	}
	scnr.close();
	
}


	
}



