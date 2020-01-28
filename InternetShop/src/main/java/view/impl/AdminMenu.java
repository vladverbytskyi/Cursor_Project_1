package view.impl;

import view.Menu;

public class AdminMenu implements Menu {
    @Override
    public void show() {
        System.out.println("Your welcome in admin page");
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