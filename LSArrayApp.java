import java.util.*;
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

	//methods
	public static String makeInfo(String stage, String day, String startTime){
		return stage + " " + day + " " + startTime;
		}
	
	public void printAreas(String stage, String day, String startTime){
		boolean check = false;
		for (int i = 0; i <= arrLength -1; i++){
			if (LSArray[i].getInfo().equals(LSArrayApp.makeInfo(stage, day, startTime))){
				System.out.println("Zones: " + Arrays.toString(LSArray[i].getZones()));
				check = true;
				}
			}
		if (check = false){
			System.out.println("Areas not Found");
			}
		}
	
	public void printAllAreas(){
		for (int i = 0; i < arrLength-1; i++){
			System.out.println(LSArray[i]);
			}
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

		//Scanner scan = new Scanner(System.in);
		if(args.length == 3){
			LSArray.printAreas(args[0],args[1],args[2]);
			}
		else{
			LSArray.printAllAreas();
			}
	
		
		
		}
	}




