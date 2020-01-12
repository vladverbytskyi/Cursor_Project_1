package view.impl;

import service.UserServiceImpl;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {
    private UserServiceImpl userServiceImpl;
    private ProductsMenu productsMenu;
    private AdminMenu adminMenu;
    private Scanner scanner;

   public void loginUserMenu(Scanner scanner) {
        System.out.println("Input login:");
        String login = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

        if (userServiceImpl.login(login, password)) {
            productsMenu.show();
        }
////        else if (userServiceImpl.login(admin, admin)) {
////            adminMenu.show();
//        }
        else {
            System.out.println("Wrong username/pasword");
            show();
        }
    }

    @Override
    public void show() {
        System.out.println("Authorization");
        loginUserMenu(scanner);
    }

    @Override
    public void back() {
        // повинен повертатися на крок назад
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
