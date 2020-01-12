package service;

public interface UserService {
    /**
     * Used to login a user
     * @param login user name
     * @param password user password
     * @return outcome of login - success or not
     */
    boolean login(String login, String password);
}
