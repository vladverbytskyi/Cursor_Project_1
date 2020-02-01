package service.impl;

import dao.*;
import model.Order;
import model.Product;
import model.User;
import service.ProductService;
import service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoFileImpl();
    ProductDao productDao = new ProductDaoFileImpl();
    OrderDao orderDao = new OrderDaoFileImpl();

    @Override
    public boolean login(String login, String password) {
        boolean isCreateUser = false;
        User userWithDatabase = userDao.getUserByLogin(login);
        if (userWithDatabase != null && userWithDatabase.getLogin().equals(login) && userWithDatabase.getPassword().equals(password)) {
            isCreateUser = true;
        }
        return isCreateUser;
    }

    public boolean registration(String name, String login, String password, String email) {
        boolean isCreateUser = false;
        User user = new User(name, login, password, email);

        // delete only for test
            Product product = new Product("Milk","Village Milk","Dairy product",12621,
                    "Very good milk", new BigDecimal(3.45),15);
            Order.PositionItem positionItem = new Order.PositionItem(product,7);

            Product product1 = new Product("Bread", "Village Bread","Flour products",36221,
                    "Only beked bread",new BigDecimal(2.21),20);
            Order.PositionItem positionItem1 = new Order.PositionItem(product1,7);

            List<Order.PositionItem> m = new ArrayList<>();
            m.add(positionItem);
            m.add(positionItem1);

            Order order = new Order(m,user.getLogin(), Order.StatusOrder.IN_PROCESS);
            user.setOrders(null);
            orderDao.createOrderInDatabase(order);
        productDao.createProductInDatabase(product1);
        productDao.createProductInDatabase(product);
        //delete only for test

        User userWithDatabase = userDao.getUserByLogin(user.getLogin());
        if (userWithDatabase == null) {
            userDao.createUserInDatabase(user);
            isCreateUser = true;
        }
        return isCreateUser;
    }
}