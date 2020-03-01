import java.util.*;
import java.io.*;

public class LSBSTApp{
	//instance variables
	private BinarySearchTree<LSC> LSTree;	
	
	//constructors
	public LSBSTApp(){
		LSTree = new BinarySearchTree<LSC>();
		}

	//methods
	public void addToTree(LSC item){
		LSTree.insert(item);
		}

	public void printAreas(String stage, String day, String startTime){
		System.out.println("Zones: " + Arrays.toString((LSTree.find(new LSC(stage,day,startTime)).getData()).getZones()));// check for not found
		}
	
	public void printAllAreas(){
		LSTree.inOrder();
		}
		
	

	//main
	public static void main(String[] args){
		LSBSTApp LSCTree = new LSBSTApp();
		try{
			Scanner scFile = new Scanner(new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
		
			while(scFile.hasNextLine()){
				LSCTree.addToTree(new LSC(scFile.nextLine()));
				}
			}

		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			}

		if (args.length == 3){
			LSCTree.printAreas(args[0],args[1],args[2]);
			}
		else{
			LSCTree.printAllAreas();
			}


		}//end of main

	}// end of class

