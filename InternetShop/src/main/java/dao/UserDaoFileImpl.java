package dao;

import com.fasterxml.jackson.core.type.TypeReference;
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
            TypeReference<Map<String, User>> typeReference = new TypeReference<>(){};
            usersMap = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeIntoFile(){
        try {
            mapper.writeValue(file, usersMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
