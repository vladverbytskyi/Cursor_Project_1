package service.impl;

import dao.UserDao;
import dao.UserDaoFileImpl;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoFileImpl();

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userDao.getAllUsers();
        if (allUsers.isEmpty()) {
            System.out.println("We don't have any Users");
        }
        return allUsers;
    }

    @Override
    public boolean createUserInDatabase(User user) {
        boolean isCreate = false;
        userDao.createUserInDatabase(user);
        if (userDao.getUserByLogin(user.getLogin()) != null) {
            isCreate = true;
        }
        return isCreate;
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public boolean updateUserInDatabase(User user) {
        boolean isUpdate = false;
        userDao.updateUserInDatabase(user);
        if (userDao.getUserByLogin(user.getLogin()) != null) {
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean deleteUserFromDatabase(User user) {
        boolean isDelete = false;
        userDao.deleteUserFromDatabase(user);
        if (userDao.getUserByLogin(user.getLogin()) == null) {
            isDelete = true;
        }
        return isDelete;
    }

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
        if (userDao.getUserByLogin(login) == null) {
            userDao.createUserInDatabase(user);
            isCreateUser = true;
        }
        return isCreateUser;
    }
}