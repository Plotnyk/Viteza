package service;

import entity.User;

public interface ServiceUser {
    public User get(String login, String password);
    public void add(User entity);

}
