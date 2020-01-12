package view.impl;

import view.Menu;

public class ProductsMenu implements Menu {

    @Override
    public void show() {
        System.out.println("Product");
        // Повинен бути пов'язаний з списком продуктів
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
