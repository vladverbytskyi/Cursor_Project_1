package dao;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("sudo", new User("sudo", "sudo", "sudo", "sudo@com.com")); //FIXME testing only ,  remove in prod
    }

    @Override
    public void createUserInDatabase(User user) {
        users.put(user.getName(), user);
        System.out.println("User " + user.getName() + " added to the database");
    }

    @Override
    public User getUserByName(String name) {
        return users.get(name);
    }

    @Override
    public void updateUserInDatabase(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public void deleteUserFromDatabase(User user) {
        users.remove(user.getName(), user);
        System.out.println("User " + user.getName() + " deleted from database");
    }

    @Override
    public User getUserByLogin(String login) {
        return users.get(login);
    }
}
