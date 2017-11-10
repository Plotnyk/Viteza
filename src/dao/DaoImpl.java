package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;
import java.util.Locale;

public class DaoImpl<T> implements Dao<T> {
    private SessionFactory factory;
    private Class<T> type;

    public DaoImpl(Class type){
        Locale.setDefault(Locale.ENGLISH);
        factory = HibernateUtil.factory();
        this.type = (Class<T>)type;
    }
    @Override
    public Long create(T obj) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            Long id = (Long) session.save(obj);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public <T> T read(Long obj) {
        Session session = factory.openSession();
        session.beginTransaction();
        T mpl = session.load((Class<T>) type,obj);
        return (T) mpl;
    }


    @Override
    public void update(T obj) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } catch (HibernateException e){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(T obj) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<T> getAll() {
        return factory
                .openSession()
                .createCriteria(type)
                .list();
    }

}
