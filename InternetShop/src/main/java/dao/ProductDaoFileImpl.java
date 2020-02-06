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
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file = new File("InternetShop/src/main/java/resource/products.json");
    private static Map<Integer, Product> productsMap = new LinkedHashMap<>();

    public ProductDaoFileImpl() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    static {
        readWithFile();
        Runtime.getRuntime().addShutdownHook(new Thread(ProductDaoFileImpl::writeIntoFile));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productsMap.values());
    }

    @Override
    public void createProductInDatabase(Product product) {
        productsMap.put(product.getProductId(), product);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productsMap.get(productId);
    }

    @Override
    public void updateProductInDatabase(Product product) {
        productsMap.remove(product.getProductId());
        productsMap.put(product.getProductId(), product);
    }

    @Override
    public void deleteProductFromDatabase(Product product) {
        productsMap.remove(product.getProductId());
    }

    private static void readWithFile() {
        try {
            InputStream inputStream = new FileInputStream(file);
            Product[] products = mapper.readValue(inputStream, Product[].class);
            productsMap = Stream.of(products).collect(Collectors.toMap(Product::getProductId, Function.identity()));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeIntoFile() {
        try {
            mapper.writeValue(file, productsMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
