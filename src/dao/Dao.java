package dao;

import java.util.List;

public interface Dao<T> {
    public Long create(T obj);
    public <T> T read(Long id);
    public boolean update(T obj);
    public boolean delete(T obj);
    public List<T> getAll();
}
