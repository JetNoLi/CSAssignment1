import subprocess

originalFile = open("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt","r")
fileLines = originalFile.readlines()

fileNameOrig = "LSArrayAppdataset_.txt"
cmdInputOrig = "java LSArrayApp _"

    
for i in range(1,11):
    fileName = fileNameOrig.replace("_", str(i))
    with open(fileName, "w") as f:
        print(fileName)
        for x in range(2976):
            if (x % i == 0):
                data = fileLines[x]
                data = data[0:7]
                
                if (data[6] == " "):
                    data = data[0:6]
               
                data = data.split("_")


                cmdInput = ["java", "LSArrayApp",data[0],data[1],data[2]] 

                
                subprocess.run(cmdInput, stdout = f, text = True)
                


    

