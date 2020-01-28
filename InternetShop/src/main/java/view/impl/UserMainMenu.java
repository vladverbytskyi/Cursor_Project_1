package view.impl;

import view.Menu;

import java.util.Scanner;

public class UserMainMenu implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private String[] itemsUserMainMenu = {"1. Product list", "2. Search", "3. Add specific product to order", "4. Order checkout", "5. My account", "6. Back", "7. My Order", "0. Exit"};


    @Override
    public void show() {
        showItems(itemsUserMainMenu);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    StaticMenu.productsMenu.show();
                    break;
                case 2:
                    StaticMenu.searchMenu.show();
                    break;
                case 3:
                    StaticMenu.specificProductMenu.show();
                    break;
                case 4:
                    StaticMenu.orderCheckoutMenu.show();
                    break;
                case 5:
                     StaticMenu.myAccountMenu.show();
                    break;
                case 7:
                    StaticMenu.myOrderMenu.show();
                    break;
                case 6:
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
        StaticMenu.startMenu.show();
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}