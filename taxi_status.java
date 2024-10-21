package parking_appli;

public class taxi_status {
	
	char cur_loc;
	char pic_loc;
	char drop_loc;
	int pick_time;
	int drop_time;
	int earning;
	
	taxi_status(){
		
		this.cur_loc='A';
		this.pic_loc='A';
		this.drop_loc='A';
		this.pick_time=0;
		this.drop_time=0;
		this.earning=0;
	}
	
	public String toString() {
	    
	    System.out.println(cur_loc+"        "+pic_loc+"         "+drop_loc+"         "+pick_time+"          "+drop_time+"         "+earning);
		System.out.println();
		
		return"";
	}
}
