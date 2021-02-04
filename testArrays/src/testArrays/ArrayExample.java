package testArrays;



public class ArrayExample {
	private int checkerboard[][] = new int[8][8];
	
	public static void main(String[] args) {
	
		
		ArrayExample arrayExample = new ArrayExample();
		arrayExample.TestArrays();
	}
		
	public ArrayExample() {
			initializeArray();		
	}

	private void initializeArray()
	{
		
		for(int i=0; i<8;i++ ) {
			for(int j=0;j<8;j++) {
				checkerboard[i][j]=0;
			}
		}
	}
	
	private void setupGame()
	{
		for(int i=0; i<8;i++ ) {
			for(int j=0;j<8;j++) {
				if((i<3) && (i%2==0) && (j%2 ==1)) {
					checkerboard[i][j] = 1;
				}
				else if((i>3) && (i<8) && (i%2==0) && (j%2==1))
					checkerboard[i][j] = 1;
				else if((i>4) && (i<8) && (i%2==0) && (j%2==0))
					checkerboard[i][j] = 2;
				else if((i>4) && (i<8) && (i%2==1) && (j%2==0))
					checkerboard[i][j] = 2;
				
			}
		}
			
	}
	
	private void printBoard() 
	{
		System.out.println("Board:");
		StringBuffer buffer = new StringBuffer(" ");
		
		for(int i=0; i<8; i++) {
			for(int j=0;j<8;j++) {
				buffer.append(" " + String.valueOf(checkerboard[i][j]) + " ");
			}
		System.out.println(buffer.toString());
		
		}
	}
				
	public void TestArrays()
	{
		
		setupGame();
		printBoard();
		//empty space =0
		//black occupied
		//red occupied
		
	}
		
	
	}


/*if ((i < 3) && (i+j)% 2 == 0) {
                    checkerboard[i][j] = 1;
                }else if ((i > 4) && (i < 8) && (i+j)% 2 == 0) {
                    checkerboard[i][j] = 2;
                }
                
                */

