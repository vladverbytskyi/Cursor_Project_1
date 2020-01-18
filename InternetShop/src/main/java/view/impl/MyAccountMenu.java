package view.impl;

import view.Menu;

public class MyAccountMenu implements Menu {
    @Override
    public void show() {
        System.out.println("ffffffffffff");
        // виводить дані користувача: name, login, email
    }

    @Override
    public void back() {
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
