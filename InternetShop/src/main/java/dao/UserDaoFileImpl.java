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
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file = new File("InternetShop/src/main/java/resource/users.json");
    private static Map<String, User> usersMap = new LinkedHashMap<>();

    public UserDaoFileImpl() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    static {
        readWithFile();
        Runtime.getRuntime().addShutdownHook(new Thread(UserDaoFileImpl::writeIntoFile));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public void createUserInDatabase(User user) {
        usersMap.put(user.getLogin(), user);
    }

    @Override
    public User getUserByLogin(String login) {
        return usersMap.get(login);
    }

    @Override
    public void updateUserInDatabase(User user) {
        usersMap.remove(user.getLogin());
        usersMap.put(user.getLogin(), user);
    }

    @Override
    public void deleteUserFromDatabase(User user) {
        usersMap.remove(user.getLogin());
    }

    private static void readWithFile() {
        try {
            InputStream inputStream = new FileInputStream(file);
            User[] users = mapper.readValue(inputStream, User[].class);
            usersMap = Stream.of(users).collect(Collectors.toMap(User::getName, Function.identity()));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeIntoFile() {
        try {
            mapper.writeValue(file, usersMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
