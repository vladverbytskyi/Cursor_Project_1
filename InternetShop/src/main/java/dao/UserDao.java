package dao;

import model.User;

import java.util.Map;

/**
 * Created by Igor on 10/8/2019.
 */
public interface UserDao {
    void setUserIntoDatabase(User user); //create
    User getUserByName(String name); //read
    Map<String, User> getAll();
    void checkUserInDatabase(User user); //update
    void deleteUserFromDatabase(User user); //delete
}
