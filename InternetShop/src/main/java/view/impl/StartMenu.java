package view.impl;

import view.Menu;
import java.util.Scanner;

public class StartMenu implements Menu {

    private RegistrationMenu regMenu = new RegistrationMenu();
    private LoginMenu logUserMenu = new LoginMenu();
    private Scanner scanner = new Scanner(System.in);
    private String[] items = {"1. Login", "2. Register", "0. Exit"};

    @Override
    public void show() {
        showItems(items);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    logUserMenu.loginMenu(scanner);
                    break;
                case 2:
                    regMenu.registerMenu(scanner);
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }

    @Override
    public void back() {
        //////// не знаю, що тут має бути
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}