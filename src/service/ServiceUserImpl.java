package service;

import dao.DaoUser;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceUserImpl implements ServiceUser {

    @Autowired
    private DaoUser userDao;

    @Override
    public User get(String login, String password) {
        return userDao.read(login,password);
    }
    @Override
    public void add(User entity) {
        if (entity != null) {
            entity.setId(userDao.create(entity));
        }
    }
}
