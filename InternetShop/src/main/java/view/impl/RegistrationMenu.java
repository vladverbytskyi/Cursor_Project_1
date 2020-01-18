package view.impl;

import service.RegisterServiceImpl;
import view.Menu;

import java.util.Scanner;

public class RegistrationMenu extends RegisterServiceImpl implements Menu {
    private RegisterServiceImpl registerServiceImpl;
    private LoginMenu loginMenu = new LoginMenu();

    public void registerMenu(Scanner scanner) {
        System.out.println("Name:");
        String name = scanner.next();

        System.out.println("Login:");
        String login = scanner.next();

        System.out.println("Password:");
        String password = scanner.next();

        System.out.println("Email:");
        String email = scanner.next();

        if (true/*registration(name, login, password, email)*/) {
            loginMenu.show();
        }
        else {
            System.out.println("Введені дані некоректні");
            show();
        }
    }

    @Override
    public void show() {
        System.out.println("Show");
    }

    @Override
    public void back() {

    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void showItems(String[] items) {

    }
}
