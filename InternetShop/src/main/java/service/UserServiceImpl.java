package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

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
        User userWithDatabase = userDao.getUserByLogin(user.getLogin());
        if (userWithDatabase == null) {
            userDao.createUserInDatabase(user);
            isCreateUser = true;
        }
        return isCreateUser;
    }
}