package ua.com.manometer.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.manometer.model.Contact;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Contact getContact(Integer id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> listContact() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
        if (contact != null) {
            sessionFactory.getCurrentSession().delete(contact);
        }
    }

    @Override
    public List<Contact> listContact(String customer) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
        criteria.add(Restrictions.eq("customer", customer));
        return criteria.list();
    }
}

