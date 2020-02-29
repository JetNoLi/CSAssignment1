public class LSC extends Key{
	
	//key stage , day, month
	private int[] zones;

	public LSC(int stage, int day, int time, String key, int[] zones){
		super(stage,day,time,key);
		this.zones = zones;
		}

	public LSC(Key k, int[] zones){
		super(k.getStage(), k.getDay(), k.getTime(), k.getKey());
		}

	public void printZones(){
		for (int i = 0 ; i <= zones.length-1; i++){
			System.out.print(zones[i] + " ");
			}
		}

	public void printLSC(){
		getKey();
		System.out.print(" ");
		printZones();
		}

	}// end of class
	
						
					


							
				
			
