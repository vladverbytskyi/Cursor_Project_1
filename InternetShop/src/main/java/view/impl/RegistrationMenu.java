package view.impl;

import service.RegisterService;
import service.UserService;
import view.Menu;

import java.util.Scanner;

public class RegistrationMenu implements Menu {
    private RegisterService registerService;

    void registerMenu(Scanner scanner) {
        System.out.println("Name:");
        String name = scanner.nextLine();

        System.out.println("Login:");
        String login = scanner.nextLine();

        System.out.println("Password:");
        String password = scanner.nextLine();

        System.out.println("Email:");
        String email = scanner.nextLine();

        if (registerService.registration(name, login, password, email)) {
            System.out.println("Тут щось має бути ))))))))  відкриватися наступне меню ");
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
