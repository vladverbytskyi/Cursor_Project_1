package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private Integer id;
    private String login;
    private String password;
    private String email;
    private Bucket bucket;
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(String name, Integer id, String login, String password, String email) {
        this.name = name;
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.bucket = new Bucket();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}


