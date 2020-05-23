/**
 * 
 */
package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author suare
 *
 */
public class Utils {
	public static Date toDate(String date) throws DateFormatException {
		try {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    formatter.setLenient(false);
		    return formatter.parse(date);
		}
		catch(ParseException ex) {
			throw new DateFormatException(date);
		}
	}
	
}

