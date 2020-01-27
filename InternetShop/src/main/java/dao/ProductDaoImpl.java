package dao;

import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductDaoImpl implements ProductDao {

    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product("Milk","Village Milk","Dairy product",121,
                "Very good milk", BigDecimal.valueOf(3.45),15));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList(products.values());
    }

    @Override
    public void createProductInDatabase(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product " + product.getName() + " added to the database");
    }

    @Override
    public Product getProductById(Integer productId) {
        return products.get(productId);
    }

    @Override
    public void updateProductInDatabase(Product product) {
        products.put(product.getProductId(), product);
    }

    @Override
    public void deleteProductFromDatabase(Product product) {
        products.remove(product.getProductId(), product);
    }
}
