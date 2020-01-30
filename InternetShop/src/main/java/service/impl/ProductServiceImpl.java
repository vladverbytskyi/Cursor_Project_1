package service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Order;
import model.Product;
import service.ProductService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    public List<Product> getAllProducts()
    {
        List<Product> productsList = new ArrayList<>();
        return productsList;
    }

    @Override
    public void createProductInDatabase(Product product) {
    }

    @Override
    public Product getProductById(Integer productId) {
        return null;
    }

    @Override
    public void updateProductInDatabase(Product product) {

    }

    @Override
    public void deleteProductFromDatabase(Product product) {

    }
}
