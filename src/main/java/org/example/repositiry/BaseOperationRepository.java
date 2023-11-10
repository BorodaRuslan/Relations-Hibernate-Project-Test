package org.example.repositiry;
import java.util.List;
import java.util.function.Predicate;


public interface BaseOperationRepository<T> {

    public T create(T entity);

    public List<T> readAll();

    public T readById(long id);

    public T update(long id, String position, double salary);

    public T delete(long id);



}
