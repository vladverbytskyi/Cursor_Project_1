package view.impl;

import service.UserService;
import view.Menu;
import java.util.Scanner;

public class LoginUserMenu implements Menu {
    private UserService userService;

    void loginUserMenu(Scanner scanner) {
        System.out.println("Input login:");
        String login = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

        if (userService.login(login, password)) {
            System.out.println("Тут щось має бути ))))))))  відкриватися наступне меню ");
        }
        else {
            System.out.println("Wrong username/pasword");
            show();
        }
    }

    @Override
    public void show() {
        System.out.println("ffihgrkfgfim");

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
