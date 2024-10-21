package parking_appli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class booking_history {

	static HashMap<Integer,ArrayList<taxi_status>>booking_taxi=new HashMap<>();
	
	public void addbooking(int id,taxi_status ts) {
		
		if(booking_taxi.containsKey(id)) {
			
			booking_taxi.get(id).add(ts);
		}else {
			
			booking_taxi.put(id, new ArrayList<taxi_status>());
			booking_taxi.get(id).add(ts);
		}
		
	}
	
	public void viewbookedtaxi() {
		
       for(Entry<Integer, ArrayList<taxi_status>> id:booking_taxi.entrySet()) {
    	  
    	   int total=0;
    	   System.out.println("TAXI_ID  CUR_LOC  PICK_LOC  DROP_LOC  PICK_TIME  DROP_TIME  EARNING");
    	   System.out.println();
    	 
    	   for(taxi_status st:id.getValue()) {
    		   
    		   System.out.print(id.getKey()+"        ");
    		   System.out.println(st);
    	       total+=st.earning;
    	   }
    	   System.out.println("Taxi - "+id.getKey()+" Total Earnings : "+total);
    	   System.out.println();
       }
	}
	
}
