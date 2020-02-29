public class LSC extends Key{
	
	//Key + stores zones
	private int[] zones;

	//constructors
	public LSC(int stage, int day, int time, int[] zones){
		super(stage,day,time,key);
		this.zones = zones;
		}

	public LSC(Key k, int[] zones){
		super(k.getStage(), k.getDay(), k.getTime());
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
		super(Integer.parseInt(varArray[0]),varArray[1],varArray[2]);
		this.zones = zoneA;
		}

	
	
	//methods

	}// end of class
	
						
					


							
				
			
