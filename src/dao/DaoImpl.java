package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Repository
@Transactional
public class DaoImpl<T> implements Dao<T> {

    @Autowired
    private SessionFactory factory;
    private Class<T> type;

    public DaoImpl(Class<T> type){
        Locale.setDefault(Locale.ENGLISH);
        this.type = type;
    }

    @Override
    public Long create(T obj) {
        return (Long)factory.getCurrentSession().save(obj);
    }

    @Override
    public <T> T read(Long id) {
        return (T)factory.getCurrentSession().get(type, id);
    }


    @Override
    public boolean update(T obj) {
        try {
            factory.getCurrentSession().saveOrUpdate(obj);
            return true;
        } catch (HibernateException e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(T obj) {
        try {
            factory.getCurrentSession().delete(obj);
            return true;
        } catch (HibernateException e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<T> getAll() {
        return factory
                .getCurrentSession()
                .createCriteria(type)
                .list();
    }


}
