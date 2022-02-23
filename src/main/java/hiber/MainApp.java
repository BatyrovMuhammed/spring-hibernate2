package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Handler;

public class MainApp {
   public static void main(String[] args) throws SQLException {
       AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(AppConfig.class);

       UserService userService = context.getBean(UserService.class);
       UserService userService1 = context.getBean(UserService.class);
       userService1.listCar1("BMW");
       userService1.listCar2(14);

     Car car = new Car("mers",32);
     Car car1 = new Car("plus",13);
     Car car2 = new Car("ferrari",45);
     Car car3 = new Car("BMW",14);

 userService.add(new User("Muhammed", "Batyrov", "muhammed@mail.ru",new Car("mers",32)));
userService.add(new User("Rahim", "Kurbanov", "rahim@mail.ru",new Car("plus",13)));
userService.add(new User("Nurullo", "Salimov", "nurullo@mail.ru",new Car("ferrari",45)));
userService.add(new User("Aisuluu", "Nurmatov", "aisuluu@mail.ru",new Car("BMW",14)));

       List<User> users = userService.listUsers();
       for (User user : users) {
           System.out.println("Id = " + user.getId());
           System.out.println("First Name = " + user.getFirstName());
           System.out.println("Last Name = " + user.getLastName());
           System.out.println("Email = " + user.getEmail());
           System.out.println();
       }
       context.close();
   }
}