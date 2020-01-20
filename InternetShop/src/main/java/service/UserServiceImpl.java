package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String login, String password) {
        boolean isCreateUser = false;
        UserDao userDao = new UserDaoImpl();
        User userWithDatabase = userDao.getUserByLogin(login);
        if (userWithDatabase.getLogin().equals(login) && userWithDatabase.getPassword().equals(password)){
            isCreateUser = true;
        }
        return isCreateUser;
    }
}