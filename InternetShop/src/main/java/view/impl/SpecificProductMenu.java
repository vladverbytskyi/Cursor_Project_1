package view.impl;

import view.Menu;

import java.util.Scanner;

public class SpecificProductMenu implements Menu {
    Scanner scanner;

    public void addSpecificProduct (Scanner scanner) {
        String specificProduct = scanner.nextLine();
    }

    @Override
    public void show() {
        System.out.println("Add specific product: ");
        addSpecificProduct(scanner);
    }

    @Override
    public void back() {
        StaticMenu.userMainMenu.show();
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}