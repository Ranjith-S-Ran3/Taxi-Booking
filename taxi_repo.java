package parking_appli;
import java.util.*;
import java.util.Map.Entry;

public class taxi_repo {

	static HashMap<Integer,taxi_status>taxis=new HashMap<>();
    private static int id=1;
    
	public void booktaxi() {
		
		if(taxis.size()<4) {

			taxis.put(id++,new taxi_status());
		}
		
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a pick loc : ");
		char pick=n.next().charAt(0);
		System.out.println("Enter a drop loc : ");
		char drop=n.next().charAt(0);
		System.out.println("Enter a pick time : ");
		int pic_time=n.nextInt();
		
	    if(pick<'A' || drop>'F' || pick>=drop || pic_time<=0 || pic_time>24) {
	    	System.out.println("Enter a valid pick up/drop point...");
	    	return;
	    }
	    taxi_status ready_taxi=null;
	    int min=Integer.MAX_VALUE; 
	  
	    int cur_id=-1;
	    
	  for(Entry<Integer, taxi_status> taxi:taxis.entrySet()) {  
	      
		  taxi_status t=taxi.getValue();
	    	
	    	if(t.drop_time<=pic_time && Math.abs(pick-t.cur_loc)<=min) {
	    	  
	    	  if(min==Math.abs(pick-t.cur_loc)){
	    		 
	    		  int min_earn=Math.min(ready_taxi.earning,t.earning);
	    		  
	    		  if(min_earn==t.earning && t.earning!=0) {
	    			min=Math.abs(pick-t.cur_loc);
	  	    		ready_taxi=t;
	  	    		cur_id=taxi.getKey();
	    		  }
	    	  }else {
	    		
	    		min=Math.abs(pick-t.cur_loc);
	    		ready_taxi=t;
	    	    cur_id=taxi.getKey();
	    	  }
	    	  
	       }
	    }
	  
	    if(min==Integer.MAX_VALUE || ready_taxi==null) {
	    	System.out.println("No Available taxis \n Cancel a booking");
	    	return;
	    }
	    	
	    	int dis=drop-pick;
	    	
	    	taxi_status ntaxi=new taxi_status();
	    	
	    	ntaxi.cur_loc=drop;
	    	ntaxi.drop_loc=drop;
	    	ntaxi.pic_loc=pick;
	    	ntaxi.pick_time=pic_time;
	    	ntaxi.drop_time=pic_time+dis;
	    	ntaxi.earning=100+((dis*15)-5)*10;
	    	
	    	System.out.println("Taxi - "+cur_id+" Can Be Allotted");
	    
	    	booking_history bh=new booking_history();
	    	bh.addbooking(cur_id, ntaxi);
	    	
	    	taxis.put(cur_id, ntaxi);
	    	
	  }
	
}