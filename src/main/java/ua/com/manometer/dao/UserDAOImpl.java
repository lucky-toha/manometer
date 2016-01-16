package ua.com.manometer.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.manometer.model.User;

import java.io.File;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void removeUser(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = (User) currentSession.load(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public User getUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public User findByLogin(String login) {

        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).
                add(Restrictions.eq("login", login)).uniqueResult();
    }


}
