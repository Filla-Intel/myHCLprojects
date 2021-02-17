package sequence;
//Travis Filla Find Longest Sequence
import java.util.Random;

public class LongestSequence {
	//array size 
	public static final int SEQ_SIZE = 100;

	public static void main(String[] args) {
		
		int startLocation = 0; //index of the 1st element of the longest sequence
		int cnt = 0;
		Random rd = new Random();	
		int[] array = new int[SEQ_SIZE];
		//int[] testArray = {37, 39, 47, 48, 35, 40, 40, 24, 47, 16, 18, 26, 14, 17, 38, 6, 37, 39, 47, 48, 49, 40, 17, 4,
		//		25, 40, 36, 43, 33, 27, 36, 39, 37, 21, 37, 24, 4, 4, 6, 47, 39, 2, 6, 37, 39, 47, 48, 49, 40, 17, 27, 24};
		
		for (int i = 0; i < array.length; i++) {
	         array[i] = rd.nextInt(50); //fills the array with random numbers 0-49
	        				
		}
		
		startLocation = findLongestSeq(array);	//returns longestSeq first index
		System.out.println();
		System.out.print("The Longest Sequence is: ");
		
		//prints out the longest sequence
		do {
			System.out.print(array[startLocation+cnt] + " ");
			cnt++;
		}while((array[startLocation+cnt-1] < array[startLocation+cnt]) && startLocation < SEQ_SIZE);
	}
	
	
	/* findLongestSeq(int [] array)
	 * starting at element 0; it will start finding the longest sequence starting at
	 * one tempLength is the variable used for the longest sequence at that point in
	 * time where longSeq is the longest sequence found. If tempLength sequence is
	 * longer it is set equal to longSeq and the first index of the longest sequence
	 * is updated
	 */
	public static int findLongestSeq(int [] array){
		
		int startIndex = 0;
		int longSeq = 1;
		int tempLength = 1;
		for (int i = 0; i < array.length; i++)	
			System.out.print(array[i]+ " "); 
		
		for(int j = 0; j < array.length-1; j++) {
			
			if(array[j] < array[j+1]) {
				tempLength++;
				if(longSeq < tempLength) {
					longSeq = tempLength;
					startIndex = j+1-longSeq+1;
				}
					
			}
			else {
				//if the element is not greater than the previous resets the tempLength to 1
				//begins looking for a fresh sequence
				tempLength = 1;
				
			}
			
		}
		
		//returns the first element of the longest sequence
		return startIndex;
				
		
	}

}
