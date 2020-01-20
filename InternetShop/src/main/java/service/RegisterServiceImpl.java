package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class RegisterServiceImpl implements RegisterService {
    @Override
    public boolean registration(String name, String login, String password, String email) {
        boolean isCreateUser = false;
        UserDao userDao = new UserDaoImpl();
        User user = new User(name,login,password,email);
        User userWithDatabase = userDao.getUserByLogin(user.getLogin());
        if (userWithDatabase == null && !userWithDatabase.getEmail().equals(email)){
            userDao.createUserInDatabase(user);
            isCreateUser = true;
        }
        return isCreateUser;
    }
}