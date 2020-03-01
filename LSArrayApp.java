import java.util.Scanner;
import java.io.File;

public class LSArrayApp{
	//Array of LSC objects as instance variable
	private LSC[] LSArray;

	//constructor
	public LSArrayApp(){
		LSArray = {}; // empty array
		}

	public LSArrayApp(LSC[] array){
		LSArray = Array;
		}
	
	//methods
	public  void addToArray(LSC item){
		int len = LSArray.length;
		LSC[] newLSArray = new LSC[len+1];
		
		for (int i = 0; i <= len-1; i++){
			newLSArray[i] = LSArray[i];
			}
		
		newLSArray[len] = item; 
		LSArray = newLSArray;
		}
	
	public LSC[] getArray(){
		return LSArray;
		}

	//main
	public static void main(String[] args){
		File file = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final");// add exc file not found
		Scanner scFile = new Scanner(file);
		LSArrayApp LSArray = new LSArrayApp();
		while(scFile.hasNextLine()){
			LSC newLSC = new LSC(scFile.nextLine());
			LSArray.addToArray(item);
			}
		LSC[] array = LSArray.getArray();	
		System.out.println(array[0]);
		}
	}




