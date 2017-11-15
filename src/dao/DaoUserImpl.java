package dao;

import entity.User;
import org.hibernate.Query;

import java.util.Queue;

public class DaoUserImpl extends DaoImpl<User> implements DaoUser {
    public DaoUserImpl() {
        setClazz(User.class);
    }

    @Override
    public User read(String login, String password) {
        Query query = currentSession().createQuery("select id from entity.User where login = :login and password = :password");
        return (User)query.uniqueResult();
    }
}
