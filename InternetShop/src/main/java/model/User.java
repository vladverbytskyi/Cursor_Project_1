package model;

import java.math.BigDecimal;
import java.util.*;

public class User {
    private String name;
    private String login;
    private String password;
    private String email;
    private Boolean statusUser;
    private List<Order> orders;
    private Order currentOrder;
    private UserRole userRole;
    private BigDecimal money;

    public User(){}
    public User(String name, String login, String password, String email) {
        super();
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public Boolean getStatusOrder() {
        return statusUser;
    }

    public void setStatusOrder(Boolean statusOrder) {
        this.statusUser = statusOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Order> getOrders() {
        return new ArrayList<>(this.orders);
    }

    public void setOrders(Order item) {
        this.orders.add(item);
        this.currentOrder = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getOrders(), user.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLogin(), getPassword(), getEmail(), getOrders());
    }

    enum UserRole {
        REGURAL, ADMIN
    }
}


