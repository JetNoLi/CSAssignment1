import java.util.*;
import java.io.*;

public class LSBSTApp{
	//instance variable - Binary Search Tree of Type LSC
	private BinarySearchTree<LSC> LSTree;
	private int inCounter; //Instrumentation counter variable	
	
	//constructor - Creates an empty Binary Search Tree of Type LSC and stores it as an instance variable which we	can access through various accessor methods
	
	public LSBSTApp(){
		LSTree = new BinarySearchTree<LSC>();
		inCounter = 0;
		}

	//methods 
	public void addToTree(LSC item){ // inserts item into the LSC BST 
		LSTree.insert(item);
		}

	public void printAreas(String stage, String day, String startTime){// prints out the zones matching the key
		
		try{
			//LSC item = LSTree.find(new LSC(stage,day,startTime)).getData()// finds the matching LSC in the
			System.out.println("Areas Affected: " + Arrays.toString((LSTree.find(new LSC(stage,day,startTime)).getData()).getZones()));// check for not found
		
			}

		catch(NullPointerException e){
			System.out.println("Area Not Found");
			}
		}

	
	public void printAllAreas(){ // prints out a list of all zones affected
		LSTree.inOrder();
		}
		
	

	//main
	public static void main(String[] args){
		LSBSTApp LSCTree = new LSBSTApp(); // create and instance of Object which store LSC BST
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
		else if (args.length == 0){
			LSCTree.printAllAreas();
			}
		else{
			System.out.println("Input entered in Incorrectly. Please Enter in the form:");
			System.out.println(" stage day time, i.e. 1 1 10");
			}


		}//end of main

	}// end of class

