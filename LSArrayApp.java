import java.util.*;
import java.io.*;

public class LSArrayApp{
	//LSC Array and Array Length as instance variables
	private int arrLength;
	private LSC[] LSArray;
	private int inCounter; // instrumentation counter

	//constructor
	/** creates an empty array and stores it and its length as instance variables allows us to vary the size of the input data, meaning we do not need to know the size of the array before hand */

	public LSArrayApp(){ // creates an empty array and stores it and its length as instance variables
		LSArray = null; 
	       	arrLength = 0;
		inCounter = 0;	
		}

	public LSArrayApp(LSC[] array){ // sets LSArray to this array and adjusts its length accordingly
		LSArray = array;
		arrLength = array.length;
		inCounter = 0;
		}
	
	//methods
	public int getLength(){
		return arrLength;
		}

	/** adds an item to the array */
	public  void addToArray(LSC item){ // adds an item to the stored array 

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

	/**Puts input in the same format as command Line Argument Input */
	public static String makeInfo(String stage, String day, String startTime){
		//returns key in same format as Command Line Argument Input
		return stage + " " + day + " " + startTime;
		}
	
	/** uses a for loop to find the matching item in the array, it then prints out the corresponding item in the array */
	public void printAreas(String stage, String day, String startTime){
		boolean check = false;// check if area is found

		for (int i = 0; i <= arrLength -1; i++){
			// instrumentation -  check keys are the same
			inCounter++;

			if (LSArray[i].getInfo().equals(LSArrayApp.makeInfo(stage, day, startTime))){

				System.out.println("Areas Affected: " + Arrays.toString(LSArray[i].getZones()));
				check = true;
				break;
				}
			}

		if (check == false){
			System.out.println("Areas not Found");
			}
		}
	
	/** uses a for loop to print all data stored in LSC array */
	public void printAllAreas(){
		for (int i = 0; i < arrLength-1; i++){
			System.out.println(LSArray[i]);
			}
		}

	
	//methods for instrumentation 
	public int getInCounter(){
		return inCounter;
		}
	
	public void resetCounter(){
		inCounter = 0;
		}
	
	/**does the same comparitve operations as printAreas but does not print anything, used for part 5 test purposes */
	public void printAreasNull(String stage, String day, String startTime){
		for (int i = 0; i <= arrLength -1; i++){
                        // instrumentation -  check keys are the same
                        inCounter++;

                        if (LSArray[i].getInfo().equals(LSArrayApp.makeInfo(stage, day, startTime))){
                                break;
                                }
                        }
		}



	//main
	public static void main(String[] args){
		LSArrayApp LSArray = new LSArrayApp();

		try{
			File file = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
			Scanner scFile = new Scanner(file);
                	while(scFile.hasNextLine()){
                        	LSC newLSC = new LSC(scFile.nextLine());
                        	LSArray.addToArray(newLSC);
                        	}

			}

		//Exception if file it not found
		catch(FileNotFoundException e){
			System.out.println("Error: File Not Found");
			}

		if(args.length == 3){
			LSArray.printAreas(args[0],args[1],args[2]);
			System.out.println("Instrumentation Counter = " + LSArray.getInCounter());
			}
	
		else if (args.length == 0){
                        LSArray.printAllAreas();
			System.out.println("Instrumentation Counter = " + LSArray.getInCounter());
                        }

                else{
                        System.out.println("Error Input entered in Incorrectly. Please Enter in the form:");
                        System.out.println(" stage day time, i.e. 1 1 10");
			System.out.println("Instrumentation Counter = " + LSArray.getInCounter());

                        }		
		
		}// end of main
	}




