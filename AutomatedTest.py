import subprocess

fileName = "SetData_.txt"
outFileName = "LSArrayAppOutputData_.txt"
program = "Test"
for x in range(1,11):
    curFileName = fileName.replace("_",str(x))
    #curOutFileName = outFileName.replace("_",str(x))
    with open(curFileName,"w") as f:
        subprocess.run(["shuf","-n",str(x*276),"Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"], stdout = f, text = True)
    
    for y in range(2):

        if (y==1):
            outFileName = "LSBSTAppOutputData_.txt"
            program = "Test2"
        else:
            outFileName = "LSArrayAppOutputData_.txt"
            program = "Test"

        curOutFileName = outFileName.replace("_",str(x))

        with open(curOutFileName,"w") as f:
            setDataFile = open(curFileName, "r")
            lines = setDataFile.readlines()
            for i in lines:
                data = i
                data = data[0:7]
                
                if (data[6] == " "):
                    data = data[0:6]
                
                info = data.split("_");

                subprocess.run(["java",program,info[0], info[1], info[2], curFileName], stdout = f, text = True)
    

