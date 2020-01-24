package view.impl;

import view.Menu;

import java.util.Scanner;

public class ProductsMenu implements Menu {
    private Scanner scanner;

    public void productList (Scanner scanner) {
        // тут повинен відкриватися список продукції ??

    }

    @Override
    public void show() {
        System.out.println("Product list");
        productList(scanner);
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void back() {
        // реалізація беку
    }
}
