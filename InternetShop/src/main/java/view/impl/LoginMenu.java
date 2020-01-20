package view.impl;

import service.UserServiceImpl;
import view.Menu;
import java.util.Scanner;

public class LoginMenu implements Menu {
    private UserMainMenu userMainMenu = new UserMainMenu();
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void loginMenu(Scanner scanner) {
        System.out.println("Input login:");
        String login = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

       if (userServiceImpl.login(login, password)) {
           userMainMenu.show();
        }
//        else if (userServiceImpl.login(admin, admin)) {
//            adminMenu.show();
//        }
        else {
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
