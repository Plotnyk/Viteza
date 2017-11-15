package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DaoImpl<T> implements Dao<T> {   //<T extends Serializable>

    @Autowired
    private SessionFactory factory;


    private Class<T> clazz;

    @Override
    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    protected Session currentSession() {
        return factory.getCurrentSession();
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        try {
            factory.getCurrentSession().saveOrUpdate(entity);
            return true;
        } catch (HibernateException e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Long create(T entity) {
        return (Long)factory.getCurrentSession().save(entity);
    }

    @Override
    public <T> T read(Long entityId) {
        return (T)factory.getCurrentSession().get(clazz, entityId);
    }


    @Override
    public boolean update(T entity) {
        try {
            factory.getCurrentSession().save(entity);
            return true;
        } catch (HibernateException e) {
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(T entity) {
        try {
            factory.getCurrentSession().delete(entity);
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
                .createQuery("from" + clazz.getName()).list();
    }


}
