package dao;

import model.Product;
/**
 * Created by Igor on 10/8/2019.
 */
public interface ProductDao {
    void getAllProducts();
    void createProductInDatabase(Product product);
    Product getProductById(Integer productId);
    void updateProductInDatabase(Product product);
    void deleteProductFromDatabase(Product product);
}
