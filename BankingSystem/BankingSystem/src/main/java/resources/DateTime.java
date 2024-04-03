package resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
	
	 public String dateTime() {
	    	LocalDateTime dt = LocalDateTime.now();
	    	DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:MM:ss");
	    	String form = dt.format(d);
	    	
			return form;
	    	
	    }
}
