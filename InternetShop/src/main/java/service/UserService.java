package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean createUserInDatabase(User user);

    User getUserByLogin(String login);

    boolean updateUserInDatabase(User user);

    boolean deleteUserFromDatabase(User user);

    boolean login(String username, String password);

    boolean registration(String name, String login, String password, String email);
}
