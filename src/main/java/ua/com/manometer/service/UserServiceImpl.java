package ua.com.manometer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.manometer.dao.UserDAO;
import ua.com.manometer.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public User getUser(Integer userId) {
        return userDAO.getUser(userId);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return userDAO.listUser();
    }

    @Override
    @Transactional
    public List<User> listUser(Integer page, Integer count) {
        return userDAO.listUser(page, count);
    }

    @Override
    @Transactional
    public void removeUser(Integer id) {
        userDAO.removeUser(id);
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    @Transactional
    public Long getUsersCount() {
        return userDAO.getUsersCount();
    }


}
