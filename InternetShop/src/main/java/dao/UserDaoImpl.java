package dao;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("sudo", new User("sudo", "sudo", "sudo", "sudo@com.com")); //FIXME testing only ,  remove in prod
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList(users.values());
    }

    @Override
    public void createUserInDatabase(User user) {
        users.put(user.getLogin(), user);
        System.out.println("User " + user.getLogin() + " added to the database");
    }

    @Override
    public User getUserByLogin(String login) {
        return users.get(login);
    }

    @Override
    public void updateUserInDatabase(User user) {
        users.put(user.getLogin(), user);
    }

    @Override
    public void deleteUserFromDatabase(User user) {
        users.remove(user.getLogin(), user);
        System.out.println("User " + user.getLogin() + " deleted from database");
    }
}
