package dao;

import entity.User;

public interface DaoUser extends Dao<User>{
    User read(final String login, final String password);
}
