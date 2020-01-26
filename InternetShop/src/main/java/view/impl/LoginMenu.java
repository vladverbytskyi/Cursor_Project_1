package view.impl;

import service.UserService;
import service.UserServiceImpl;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {
    public static String USER_LOGIN = null;

    private UserService userService = new UserServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void loginMenu(Scanner scanner) {
        System.out.println("Input login:");
        String login = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

        if (userService.login(login, password)) {
            //StaticMenu.userMainMenu.show();
            USER_LOGIN = login;
        } else if (login.equals("admin") && password.equals("admin")) {
         //   StaticMenu.adminMenu.show();
        } else {
            System.out.println("Wrong username/pasword");
            show();
        }
    }

    @Override
    public void show() {
        System.out.println("Authorization");
        loginMenu(scanner);
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