/**
 * 
 */
package main;

/**
 * @author suare
 *
 */
public class DateFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public DateFormatException(String date) {
        super("La fecha " + date + " no tiene un formato correcto (dd/mm/yyyy)");
    }

}
