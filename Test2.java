import java.util.*;
import java.io.*;

public class Test2{
        private String fileName;

        public Test2(String file){
                fileName = file;
                }

        public static void main(String[] args){
                LSBSTApp LSCTree = new LSBSTApp();

                try{
                        Scanner scFile = new Scanner(new File(args[3]));
                        while(scFile.hasNextLine()){
                                LSC newLSC = new LSC(scFile.nextLine());
                                LSCTree.addToTree(newLSC);
                                }

                        }

                //Exception if file it not found
                catch(FileNotFoundException e){
                        System.out.println("Error: File Not Found");
                        }

                if(args.length == 4){
                        LSCTree.printAreasNull(args[0],args[1],args[2]);
                        System.out.println("Find Counter = " + LSCTree.getFinCounter());
			System.out.println("Insert Counter = " + LSCTree.getInsCounter());
                        }

                else if (args.length == 0){
                        LSCTree.printAllAreas();
                        }

                else{
                        System.out.println("Input entered in Incorrectly. Please Enter in the form:");
                        System.out.println(" stage day time, i.e. 1 1 10");
                        }

                }
        }

