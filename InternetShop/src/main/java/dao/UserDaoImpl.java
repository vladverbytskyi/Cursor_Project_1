package dao;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private Map<String, User> usersList = new HashMap<>();

    @Override
    public void setUserIntoDatabase(User user) {
    }

    @Override
    public User getUserFromDatabase() {
        return null;
    }

    @Override
    public void checkUserInDatabase(User user) {
    }
}
