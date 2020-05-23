/**
 * 
 */
package dao;

import java.util.List;
import java.util.Optional;

import main.DuplicateEntityException;

/**
 * @author suare
 *
 */
public interface DAO<T> {
	public void add(T t) throws DuplicateEntityException;
	public void saveAll();
    public T get(String id); 
    public List<T> list();
    public boolean loadData();

}
