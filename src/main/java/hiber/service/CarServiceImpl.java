package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private UserDao userDao;

    @Autowired
    public CarServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        userDao.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCar() {
        return userDao.listCar();
    }
}
