package dao;

import model.User;

import java.util.Map;

/**
 * Created by Igor on 10/8/2019.
 */
public interface UserDao {
    void createUserInDatabase(User user);
    User getUserByName(String name);
    void updateUserInDatabase(User user);
    void deleteUserFromDatabase(User user);
}
