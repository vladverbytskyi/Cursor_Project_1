package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;

import java.io.*;
import java.util.*;

public class ProductDaoFileImpl implements ProductDao {
    private  ObjectMapper mapper = new ObjectMapper();
    private  File file = new File("InternetShop/src/main/java/resource/products.json");
    private  Map<Integer,Product> productsMap = new LinkedHashMap<>();

    @Override
    public List<Product> getAllProducts() {
        readWithFile();
        return new ArrayList<>(productsMap.values());
    }

    @Override
    public void createProductInDatabase(Product product) {
        readWithFile();
        productsMap.put(product.getProductId(),product);
        writeIntoFile();
    }

    @Override
    public Product getProductById(Integer productId) {
        readWithFile();
        return productsMap.get(productId);
    }

    @Override
    public void updateProductInDatabase(Product product) {
        readWithFile();
        productsMap.remove(product.getProductId());
        productsMap.put(product.getProductId(),product);
        writeIntoFile();
    }

    @Override
    public void deleteProductFromDatabase(Product product) {
        readWithFile();
        productsMap.remove(product.getProductId());
        writeIntoFile();
    }

    private void readWithFile() {
        try {
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Map<Integer, Product>> typeReference = new TypeReference<>() {
            };
            productsMap = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeIntoFile() {
        try {
            mapper.writeValue(file, productsMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
