package view.impl;

import dao.UserDao;
import dao.UserDaoImpl;
import model.Product;
import model.User;
import view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyOrderMenu implements Menu {
    private UserDao userDao = new UserDaoImpl();
    private String [] itemsOrderMenu = {"1. Show my orders","2. Buy", "3. Back", "0. Exit"};
    private Scanner scanner = new Scanner(System.in);
    private Boolean isWorkLoop;
    @Override
    public void show() {
        System.out.println("My orders");
        isWorkLoop = true;
        while (isWorkLoop) {
            showItems(itemsOrderMenu);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printUserOrder();
                    break;
                case 2:
                    buyProducts();
                    break;
                case 3:
                    back();
                    break;
                case 0:
                    exit();
            }
        }
    }

    @Override
    public void back() {
        isWorkLoop = false;
        StaticMenu.userMainMenu.show();
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void buyProducts() {
        User userWithDatabase = userDao.getUserByLogin(LoginMenu.USER_LOGIN);
        if (userWithDatabase == null){
            System.out.println("Doesn't find user with this nick");
        }else if(userWithDatabase.getStatusOrder()){
            userWithDatabase.getOrders().clear();
            System.out.println("You successfully bought all products");
        } else{
            System.out.println("Admin doesn't confirm your order");
        }
    }

    private void printUserOrder(){
        User userWithDatabase = userDao.getUserByLogin(LoginMenu.USER_LOGIN);
        if (userWithDatabase == null){
            System.out.println("Doesn't find user with this nick");
        }else if(userWithDatabase.getOrders() == null){
            System.out.println("Order List is empty");
        } else{
            List<Product> userOrders = new ArrayList<>(userWithDatabase.getOrders());
            for(Product item : userOrders){
                System.out.println(item);
            }
        }
    }
}
