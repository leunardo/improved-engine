package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

public class AbstractDatabase <T extends Object> {
	EntityManagerFactory factory;
	EntityManager manager;
	
	private Class<T> type;
    public AbstractDatabase(Class<T> type) {
      this.type = type;
      factory = Persistence.createEntityManagerFactory("Projeto");
      manager = factory.createEntityManager();
    }

    private Class<T> getType() {
      return type;
    }

    public T newInstance() throws Exception {
      return type.newInstance();
    }
		
	public void saveEntity (T obj) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(obj);
		tx.commit();
		
	}
	
	public T getEntity (Long id) {
		return manager.find(getType(), id);
	}
	
	public List<T> getAllEntities() {	
		return manager
					.createQuery("Select t from " + type.getSimpleName() + " t", getType())
					.getResultList();
	}	
	
	public void deleteEntity(T entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(entity);
		tx.commit();
	}
}
