package service;

import dao.Dao;
import dao.DaoImpl;
import entity.User;

import java.util.List;

public class ServiceInterfaceImpl implements ServiceInterface {
    private Dao<User> userDao;

    public ServiceInterfaceImpl() {
        this.userDao = new DaoImpl<>(User.class);
    }

    @Override
    public void create(User user) {
        if (user != null) {
            user.setId(userDao.create(user));
        }
    }

    @Override
    public void delete(User user) {
        if (user != null) {
            if (userDao.delete(user)) {
                System.out.println("Удаление записи " + user.getId() + " прошло успешно.");
            } else {
                System.out.println("При удалении записи " + user.getId() + " возникла ошибка.");
            }
        }

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
