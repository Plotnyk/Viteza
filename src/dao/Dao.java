package dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {  // extends Serializable
    public Long create(final T entity);
    public <T> T read(final Long entityId);
    public boolean update(final T entity);
    public boolean delete(final T entity);
    public void setClazz(final Class<T> clazzToSet);
    public boolean saveOrUpdate(T entity) ;
    public List<T> getAll();
}
