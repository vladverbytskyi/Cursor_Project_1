package view.impl;

import view.Menu;

public class UserMainMenu implements Menu {
    @Override
    public void show() {
        System.out.println("AHhaaa!!");
    }

    @Override
    public void back() {

    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
