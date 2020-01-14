package dao;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void setUserIntoDatabase(User user) {
        users.put(user.getName(), user);
        System.out.println("User " + user.getName() + " added to the database");
    }

    @Override
    public User getUserByName(String name) {
        return users.get(name);
    }

    @Override
    public Map<String, User> getAll() {
        return users;
    }

    @Override
    public void checkUserInDatabase(User user) {
        if (users.containsKey(user.getName())) {
            System.out.println("User " + user.getName() + " exists.");
        } else {
            System.out.println("User " + user.getName() + "doesn't exist.");
        }
    }

    @Override
    public void deleteUserFromDatabase(User user) {
        users.remove(user.getName(), user);
        System.out.println("User " + user.getName() + " deleted from database");
    }
}
