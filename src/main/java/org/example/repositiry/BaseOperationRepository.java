package org.example.repositiry;
import java.util.List;


public interface BaseOperationRepository<T> {

    public T create(T entity);

    public List<T> readAll();

    public T readById(long id);

    public T update(long id);

    public T delete(long id);

}
