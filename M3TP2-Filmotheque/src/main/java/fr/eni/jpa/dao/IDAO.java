package fr.eni.jpa.dao;

public interface IDAO<T> {	
	public void add(T t) throws Exception;
	public void delete(T t) throws Exception;
	public void update(T t) throws Exception;
}
