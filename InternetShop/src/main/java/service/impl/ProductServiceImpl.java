package service.impl;

import dao.ProductDao;
import dao.ProductDaoFileImpl;
import model.Product;
import service.ProductService;

import java.util.List;


public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoFileImpl();

    public List<Product> getAllProducts() {
        List<Product> allProducts = productDao.getAllProducts();
        if (allProducts.isEmpty()) {
            System.out.println("We don't have any Products");
        }
        return allProducts;
    }

    @Override
    public boolean createProductInDatabase(Product product) {
        boolean isCreate = false;
        productDao.createProductInDatabase(product);
        if (productDao.getProductById(product.getProductId()) != null) {
            isCreate = true;
        }
        return isCreate;
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public boolean updateProductInDatabase(Product product) {
        boolean isUpdate = false;
        productDao.updateProductInDatabase(product);
        if (productDao.getProductById(product.getProductId()) != null) {
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean deleteProductFromDatabase(Product product) {
        boolean isDelete = false;
        productDao.deleteProductFromDatabase(product);
        if (productDao.getProductById(product.getProductId()) == null) {
            isDelete = true;
        }
        return isDelete;
    }
}
