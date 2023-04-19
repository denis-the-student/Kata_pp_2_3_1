package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAll();

    User show(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void remove(long id);
}
