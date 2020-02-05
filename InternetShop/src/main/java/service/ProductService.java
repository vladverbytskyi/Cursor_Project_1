package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    boolean createProductInDatabase(Product product);

    Product getProductById(Integer productId);

    boolean updateProductInDatabase(Product product);

    boolean deleteProductFromDatabase(Product product);
}
