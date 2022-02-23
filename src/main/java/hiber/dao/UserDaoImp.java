package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCar() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car  ");
        return query.getResultList();
    }

    @Override
    public List<?> listCar1(String s) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User>users =  session.createQuery("from User ").list();
        users.stream().filter(user -> user.getCar().getModel().equals(s)).forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public List<?> listCar2(int i) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User>users =  session.createQuery("from User ").list();
        users.stream().filter(user -> user.getCar().getSeries()==i).forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
        return users;
    }
}
