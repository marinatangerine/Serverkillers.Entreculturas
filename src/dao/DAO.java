package dao;

import java.util.List;
import java.util.Optional;

import main.DuplicateEntityException;

/**Interfez que implementa los métodos de DAOFactory haciendo uso de Java Generics
 * @versión 1.0 23/05/2020
 * @author Serverkillers
 *
 */
public interface DAO<T> {
	public void add(T t) throws DuplicateEntityException;
	public void saveAll();
    public T get(String id); 
    public List<T> list();
    public boolean loadData();

}
