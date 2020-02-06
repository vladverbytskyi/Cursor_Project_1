package dao;

import model.User;
import java.util.List;

/**
 * Created by Igor on 10/8/2019.
 */
public interface UserDao {
    List<User> getAllUsers();
    void createUserInDatabase(User user);
    User getUserByLogin(String login);
    void updateUserInDatabase(User user);
    void deleteUserFromDatabase(User user);

}
