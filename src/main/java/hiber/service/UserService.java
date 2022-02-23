package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    List<?> listCar1(String s);

    List<?> listCar2(int i);

}
