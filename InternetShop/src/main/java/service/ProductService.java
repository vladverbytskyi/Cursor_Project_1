package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void createProductInDatabase(Product product);

    Product getProductById(Integer productId);

    void updateProductInDatabase(Product product);

    void deleteProductFromDatabase(Product product);
}
