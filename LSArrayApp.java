import java.util.Scanner;
import java.io.*;

public class LSArrayApp{
	//Array of LSC objects as instance variable
	private int arrLength;
	private LSC[] LSArray;

	//constructor
	public LSArrayApp(){
		LSArray = null;
	       	arrLength = 0;	// empty array
		}

	public LSArrayApp(LSC[] array){
		LSArray = array;
		arrLength = array.length;
		}
	
	//methods
	public int getLength(){
		return arrLength;
		}

	public  void addToArray(LSC item){

		LSC[] newLSArray = new LSC[arrLength+1];
	
		for (int i = 0; i <= arrLength-1; i++){
			newLSArray[i] = LSArray[i];
			}
		
		newLSArray[arrLength] = item; 
		LSArray = newLSArray;
		arrLength +=1;
		}
	
	public LSC[] getArray(){
		return LSArray;
		}

	//main
	public static void main(String[] args){
		LSArrayApp LSArray = new LSArrayApp();

		try{
			File file = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
			Scanner scFile = new Scanner(file);
			//LSArrayApp LSArray = new LSArrayApp();
                	while(scFile.hasNextLine()){
                        	LSC newLSC = new LSC(scFile.nextLine());
                        	LSArray.addToArray(newLSC);
                        	}

			}

		//Exception if file it not found
		catch(FileNotFoundException e){
			System.out.println("Error: File Not Found");
			}

		LSC[] array = LSArray.getArray();	
		
		}
	}




