/**
 * 
 */
package main;

/**
 * @author suare
 *
 */
public class DuplicateEntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateEntityException() {
		super("Ya existe un elemento con ese identificador");
	}

}
