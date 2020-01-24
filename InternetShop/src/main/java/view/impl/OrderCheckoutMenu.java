package view.impl;

import view.Menu;

import java.util.Scanner;

public class OrderCheckoutMenu implements Menu {
    private Scanner scanner;

    public void checkOrder (Scanner scanner) {
        String orderCheckout = scanner.nextLine();

    }

    @Override
    public void show() {
        System.out.println("Order checkout");
        checkOrder(scanner);
    }

    @Override
    public void back() {

    }

    @Override
    public void exit() {

    }
}
