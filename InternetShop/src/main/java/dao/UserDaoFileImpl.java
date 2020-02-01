package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Order;
import model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDaoFileImpl implements UserDao {
    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("InternetShop/src/main/java/resource/users.json");
    private Map<String, User> usersMap = new LinkedHashMap<>();
    {
        User u = new User("Igor", "javam", "root", "@");
        u.setOrders(Arrays.asList(new Order(null, u.getLogin(), Order.StatusOrder.IN_PROCESS)));
        usersMap.put("1", u);
        mapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static void main(String[] args) {


        new UserDaoFileImpl().writeIntoFile();
        new UserDaoFileImpl().readWithFile();

    }
    @Override
    public List<User> getAllUsers() {
        readWithFile();
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public void createUserInDatabase(User user) {
        readWithFile();
        usersMap.put(user.getLogin(),user);
        writeIntoFile();
    }

    @Override
    public User getUserByLogin(String login) {
        readWithFile();
        return usersMap.get(login);
    }

    @Override
    public void updateUserInDatabase(User user) {
        readWithFile();
        usersMap.remove(user.getLogin());
        usersMap.put(user.getLogin(),user);
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
            InputStream inputStream = new FileInputStream(file);
            User[] users = mapper.readValue(inputStream, User[].class);
            usersMap = Stream.of(users).collect(Collectors.toMap(User::getName, Function.identity()));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeIntoFile(){
        try {
            mapper.writeValue(file, usersMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
