package dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDaoFileImpl implements UserDao {
    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("InternetShop/src/main/java/resource/users.json");
    private Map<String, User> usersMap = new LinkedHashMap<>();

    @Override
    public List<User> getAllUsers() {
        readWithFile();
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public void createUserInDatabase(User user) {
        readWithFile();
        usersMap.put(user.getLogin(), user);
        writeIntoFile();
    }

    @Override
    public User getUserByLogin(String login) {
        readWithFile();
        System.out.println(usersMap.keySet());
        System.out.println(usersMap.values());
        return usersMap.get(login);
    }

    @Override
    public void updateUserInDatabase(User user) {
        readWithFile();
        usersMap.remove(user.getLogin());
        usersMap.put(user.getLogin(), user);
        writeIntoFile();
    }

    @Override
    public void deleteUserFromDatabase(User user) {
        readWithFile();
        usersMap.remove(user.getLogin());
        writeIntoFile();
    }

    private void readWithFile() {
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            InputStream inputStream = new FileInputStream(file);
            User[] users = mapper.readValue(inputStream, User[].class);
            usersMap = Stream.of(users).collect(Collectors.toMap(User::getName, Function.identity()));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeIntoFile() {
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.writeValue(file, usersMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
