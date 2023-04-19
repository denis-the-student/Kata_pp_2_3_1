package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User show(long id) {
        return userDAO.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void remove(long id) {
        userDAO.remove(id);
    }

    @Transactional
    public void create10users() {
        for (int i = 0; i < 10; i++) {
            User user = new User("temp", 33, "temp@temp.temp");
            userDAO.save(user);
            user.setName("Хуман" + user.getId());
            user.setEmail("test" + user.getId() + "@mail.org");
        }
    }
}
