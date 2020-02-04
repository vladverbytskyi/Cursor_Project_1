package dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductDaoFileImpl implements ProductDao {
    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("InternetShop/src/main/java/resource/products.json");
    private Map<Integer, Product> productsMap = new LinkedHashMap<>();

    @Override
    public List<Product> getAllProducts() {
        readWithFile();
        return new ArrayList<>(productsMap.values());
    }

    @Override
    public void createProductInDatabase(Product product) {
        readWithFile();
        productsMap.put(product.getProductId(), product);
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
        productsMap.put(product.getProductId(), product);
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
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            InputStream inputStream = new FileInputStream(file);
            Product[] products = mapper.readValue(inputStream, Product[].class);
            productsMap = Stream.of(products).collect(Collectors.toMap(Product::getProductId, Function.identity()));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeIntoFile() {
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.writeValue(file, productsMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
