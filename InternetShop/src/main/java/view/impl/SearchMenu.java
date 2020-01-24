package view.impl;

import view.Menu;
import java.util.Scanner;

public class SearchMenu implements Menu {
    private Scanner scanner;

    public void searchProduct (Scanner scanner) {
        show();
    }

    @Override
    public void show() {
        System.out.println("Search: ");

    }

    @Override
    public void back() {

    }

    @Override
    public void exit() {

    }
}