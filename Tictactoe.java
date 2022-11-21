package first;

import java.util.Scanner;

public class Final {

	public static int winChecker(char arr[][],int chance){
		int count_x = 0, count_o = 0,count_empty = 0;
		int win = 0;
		char winner = ' ';
//calc x and o
				for (int i = 0; i < 3; i++){
					
					for (int j = 0; j < 3 ; j++){
						if (arr[i][j] == 'X')
							count_x++;
						else if (arr[i][j] =='O')
							count_o++;
						else if (arr[i][j] =='_')
							count_empty++;
					}	
				}

				if(Math.abs((count_x - count_o)) > 1){
					System.out.println("Impossible A");
					//return 0;
				}
	//horizontal check
		for (int i = 0; i < 3; i++){	
			for (int j = 0; j < 1 ; j++){
																					//horizontal check
				if((arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i][j+2])){
					//System.out.println("in test 1");
					winner = arr[i][j];
					//System.out.println(winner + " wins");
					win++;
					return winner;
					//System.out.println((arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i][j+2]));
				}
																					//vertical check
				if((arr[0][i] == arr[0+1][i] && arr[0][i] == arr[0+2][i])){
					//System.out.println("in test 2");
					//win++;
					winner = arr[0][i];
					System.out.println(winner + " wins");
					win++;
					return winner;
					//System.out.println(arr[0][i] == arr[0+1][i] && arr[0][i] == arr[0+2][i]);				
				}	
			}
		
					//if(winner != ' '){
						//	System.out.println(winner + " wins");
						//	return win;
						//}
						
						//if(win > 1){
							//System.out.println("Impossible B");
						//	return 0;
						//}
						

				//cross checks
				if ((arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2])){
					//System.out.print(arr[0][0] + " wins C");
					winner = arr[0][0];
					return winner;
				}
				else if ((arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] == arr[2][0])){
					//System.out.print(arr[0][2] + " wins D");
					winner = arr[0][2];
					return winner;
				}
		}	
			if(chance > 9){				
				if(count_empty>1)
					System.out.println("Game not finished");
				else{
					//System.out.println("Draw");
					return 3;
				}	
			}
			return 2;
	}
	
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

//create and initialise check arrays
		int checkx[][] = new int[3][3];
		int checky[][] = new int[3][3];

		//System.out.print("Enter cells: ");
		/*String s = "123456789";
		char[] strArray = s.toCharArray();
		
		int count = 0;
		char [][] result= new char [3][3];
		
		System.out.println("---------");
//convert the data to 2d array representing grid
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 3 ; j++){
				if(count == strArray.length) break;
				result[i][j] = strArray[count]; 
				//if(result[i][j] == '_')
				//	result[i][j] = ' ';
				count++;
			}
		}*/
		
		char[][] result = {
			      {1, 2, 3}, 
			      {4, 5, 6}, 
			      {7, 8, 9}, 
			};
//create check array
				for(int j = 0; j < 3; j++){
					for(int a=0, i=2; a<=2 && i>=0; a++,i--){
						//System.out.println(j + " " + i + " " + a);
						checkx[j][a] = i;
						checky[j][a] = j;
					}
				}
				int countervar =1;
//print result array
				System.out.print("---------\n");
				for (int i = 0; i < 3; i++){
					System.out.print("| ");
					for (int j = 0; j < 3 ; j++){
						if(result[i][j] == countervar){
							countervar++;
							System.out.print("  ");
							continue;
						}
						else{
							System.out.print(result[i][j] + " ");
						}
					}
					System.out.print("|\n");
				}
				System.out.print("---------\n");

				String input = null;
				int first,second;
				int chance = 1;
				int win = 1;
				
				while(true)
				{
					try{
//input processing and error handling
					System.out.print("Enter the coordinates: ");
					input = in.nextLine();
					//System.out.print("---------\n");
					
					String pieces[] = input.split(" ");
					
					first = Integer.parseInt(pieces[0]);
					second = Integer.parseInt(pieces[1]);
					
					if (first > 3 || first < 1 || second > 3 || second < 1 ){
						System.out.println("Coordinates should be from 1 to 3!");
						continue;
					}
					first --; second--;
					
					if (result[checkx[first][second]][checky[first][second]] == 'X' || result[checkx[first][second]][checky[first][second]] == 'O'){
						System.out.println("This cell is occupied! Choose another one!");
						continue;
					}
					//break;
//ends
					//alter x and o chances
					
					
					
					if(chance % 2 == 0){
						result[checkx[first][second]][checky[first][second]] = 'O';
					}
					else{
						result[checkx[first][second]][checky[first][second]] = 'X';
					}
					chance++;
					
					//if(chance == chance){
					
					win = winChecker(result,chance);
				//}
//print result array
					
					countervar =1;
					System.out.print("---------\n");
					for (int i = 0; i < 3; i++){
						System.out.print("| ");
						for (int j = 0; j < 3 ; j++){
							if(result[i][j] == countervar){
								countervar++;
								System.out.print("  ");
								continue;
							}
							else{
								countervar++;
								System.out.print(result[i][j] + " ");
							}
						}
						System.out.print("|\n");
					}
					System.out.print("---------\n"); 	
// 1 =  preset 2 = loop 3 = Draw 4,5,0 = Win
					
					if (win != 0 && win!= 2 &&win !=3){
						System.out.println((char)win+ " wins");
						return;
					}	
					else if(win == 3){
						System.out.println("Draw");
						return;
					}
					}catch ( NumberFormatException e) {
							System.out.println("You should enter numbers!");
							continue;
						}
				}
				
				//System.out.println("End success!");
				
	}

}
/*
Loop
Array printing grid
Input Error handling

Fun Win Check
*/
