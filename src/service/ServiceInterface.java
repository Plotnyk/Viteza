package service;

import entity.User;

import java.util.List;

public interface ServiceInterface {

    void create(User user);

    void delete(User user);

    List<User> getAll();
}
