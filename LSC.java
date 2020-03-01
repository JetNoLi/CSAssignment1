public class LSC{
	
	//instance variables
	private int stage;
        private String day;
        private String time;
	private int[] zones;

	//constructors
	public LSC(int stage, String day, String time, int[] zones){
		this.stage = stage;
		this.day = day;
		this.time = time;
		this.zones = zones;
		}

	public LSC(String key){
		String[] info = key.split(" ",2);
                String[] varArray = info[0].split("_");
                String[] zoneArray = info[1].split(", ");
                int[] zoneA = new int[zoneArray.length];
                for (int i = 0; i < zoneArray.length; i++){
                        zoneA[i] = Integer.parseInt(zoneArray[i]);
                        }
		stage = Integer.parseInt(varArray[0]);
		day = varArray[1];
		time = varArray[2];
		this.zones = zoneA;
		}

	
	
	//methods
	public String toString(){
                return "Stage: "+ stage + " Day: " + day + " Time " + time + " Zones: " + zones;
                }

        public int getStage(){
                return stage;
                }

        public String getDay(){
                return day;
                }

        public String getTime(){
                return time;
                }


	}// end of class
	
						
					


							
				
			
