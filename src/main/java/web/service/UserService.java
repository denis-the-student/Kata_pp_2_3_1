package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User show(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void remove(long id);

    void create10users();
}
