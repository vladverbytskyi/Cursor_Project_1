package view.impl;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import view.Menu;

import java.util.List;
import java.util.Scanner;

public class ProductsMenu implements Menu {
    ProductService productService = new ProductServiceImpl();
    private Scanner scanner = new Scanner(System.in);
    private String[] items = {"1. Show Product list", "2. Search product by name", "8. Checkout", "9. Back", "0. Exit"};

    public void productList(Scanner scanner) {
        System.out.println("all products");
        List<Product> allProducts = productService.getAllProducts();

        if (allProducts != null) {
            final int[] i = {0};
            allProducts.forEach(a -> System.out.println(i[0]++ + ". " + a.toString()));
        }

        System.out.println(" Select product: ");
        while (true) {
            int choice = scanner.nextInt();
            showProductDetails(allProducts.get(choice));
        }
    }

    private void showProductDetails(Product product) {
        System.out.println(product);
        System.out.println("1. Add to order");
        System.out.println("9. Back");
        System.out.println("0. Exit");

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToOrder(product);
                    break;
                case 9:
                    productList(scanner);
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }

    private void addToOrder(Product product) {
        //todo
    }

    private void searchForProduct(Scanner scanner) {
        //todo
    }

    @Override
    public void show() {

        showItems(items);
        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    productList(scanner);
                    break;
                case 2:
                    searchForProduct(scanner);
                    break;
                case 9:
                    back();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
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
