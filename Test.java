import java.util.Scanner;
import java.io.File;

public class LSArrayApp{
	
	private LSC[] LSArray;

	public LSArrayApp(LSC[] LSArray){
		this.LSArray = LSArray;
		}

	public void printAreas(int stage, int day, int startTime){
		Key key = new Key(stage,day,startTime);
		boolean check = false;
		for (int i = 0 ; i < 2975; i++){
			if (LSArray[i].getKey().equals(key)){
				System.out.println(LSArray[i].printZones());
				check = true;
				}
			if (check = false){
				System.out.println("Areas not found");
				}
			}
	
	public void printAllAreas(){
		for (int i = 0; i <= 2975; i++){
			LSArray[i].printLSC();
			}
		}

	public void addToArray(LSC newLSC){
		LSC[LSArray.length+1] arr;
		for (int i = 0; i <= LSArray.length-1; i++){
			arr[i] = LSArray[i];
			}
		arr[LSArray.length] = newLSC
		}


	public static void main(String args[]){
		File file = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final");
		Scanner scan = new Scanner(file);
		int stage = 0;
		int day = 0;
		int time = 0;
		String key = "";
		int zonepos = 0; //keeps pos in array
		int count = 2; // keeps pos in key
		int commacount = 0;
		int LSClistpos = 0;
		
		LSC[] LSCArray = new LSC[2976];
		// read in line by line
		
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			int len = line.length();
			
			//create key
			stage = Integer.parseInt(line.substring(0,1));
			
			for (int i = 3; i <= len - 1; i++){ // check digits in days of the month
				if (line.substring(i-1,i).equals("_")){	
					count = i; // puts us at the time pos 
					}
				}
			day = Integer.parseInt(line.substring(2,count -1));
			time = Integer.parseInt(line.substring(count, count+2));
			count+= 2;// pos of zones
			key = list.substring(0,count);
			Key newKey = new Key(stage,day,time);
			//key variables have been stored now to create an array of zones
			//count commas to determine array size

			for (int i = count; i <= len-1; i++){
				if (line.substring(i-1,i).equals(",")){
					commacount++;
					}
				}
			int[commacount+1] zones;
			commacount = 0;
			for (int i = count; i <= len -1; i++){
				zones[zonepos] = Integer.parseInt(line.substring(i-1,i));
				i+=2; //skip pos of comma and space
				}

			//create instance of LSC Object
			LSC newLSC = new LSC(newKey,zones);
			//create array list
			LSCArray[LSClistpos] = newLSC;
			LSClistpos++;
			}//end of while loop

		LSArrayApp app = new LSArrayApp(LSCArray);

		Scanner scanIn = new Scanner(System.in);
		app.printAllAreas();

		}//end of main

