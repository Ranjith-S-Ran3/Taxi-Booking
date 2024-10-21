package parking_appli;
import java.util.*;

public class call_taxi_booking{
	
	public static void main(String[] args) {
	    Scanner n=new Scanner(System.in);
	    
	    boolean check=true;
	    
	   while(check) {
	    	
	    	System.out.println("1.booking\n2.booking history\n3.Exit");
	    	
	    	int option=n.nextInt();
	    	
	    	switch(option) {
	    	   
	    	case 1:{
	    	    taxi_repo rep=new taxi_repo();
	    	    rep.booktaxi();
	    		break;
	    	}
	    	case 2:{
	    		 booking_history bh=new booking_history();
		    	 bh.viewbookedtaxi();
	    		break;
	    	}
	    	case 3:{
	    		check=false;
	    		break;
	    	}
	    	default:{
	    		check=false;
	    		break;
	    	}
	     }
	   }
	    
	    
	}
}
