import java.util.*;
import java.io.*;

public class Test{
	private String fileName;

	public Test(String file){
		fileName = file;
		}

	public static void main(String[] args){
                LSArrayApp LSArray = new LSArrayApp();

                try{
                        Scanner scFile = new Scanner(new File(args[3]));
                        while(scFile.hasNextLine()){
                                LSC newLSC = new LSC(scFile.nextLine());
                                LSArray.addToArray(newLSC);
                                }

                        }

                //Exception if file it not found
                catch(FileNotFoundException e){
                        System.out.println("Error: File Not Found");
                        }

                if(args.length == 4){
                        LSArray.printAreasNull(args[0],args[1],args[2]);
                        System.out.println("Instrumentation Counter = " + LSArray.getInCounter());
                        }

                else if (args.length == 0){
                        LSArray.printAllAreas();
                        }

                else{
                        System.out.println("Input entered in Incorrectly. Please Enter in the form:");
                        System.out.println(" stage day time, i.e. 1 1 10");
                        }

                }
	}
