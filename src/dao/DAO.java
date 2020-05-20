/**
 * 
 */
package dao;

import java.util.List;
import java.util.Optional;

/**
 * @author suare
 *
 */
public interface DAO<T> {
	public void add(T t);
	public void saveAll();
    public Optional<T> get(String id); 
    public void update(T t, String[] params);
    public void remove(T t);
    public List<T> list();
    public boolean loadData();

}
