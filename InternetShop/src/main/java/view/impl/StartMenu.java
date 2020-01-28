package view.impl;

import view.Menu;

import java.util.Scanner;

public class StartMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private String[] items = {"1. Login", "2. Register","9. Register", "0. Exit"};

    @Override
    public void show() {
        showItems(items);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    StaticMenu.loginMenu.loginMenu(scanner);
                    break;
                case 2:
                    StaticMenu.registrationMenu.registerMenu(scanner);
                    break;
                case 9:
                    back();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }

    @Override
    public void back() {
        System.out.println("No previous page");
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}