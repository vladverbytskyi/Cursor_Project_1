package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoFileImpl implements OrderDao {
    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("InternetShop/src/main/java/resource/orders.json");
    private Map<Long,Order> ordersMap = new LinkedHashMap<>();

    @Override
    public List<Order> getAllOrders() {
        readWithFile();
        return new ArrayList<>(ordersMap.values());
    }

    @Override
    public void createOrderInDatabase(Order order) {
        readWithFile();
        ordersMap.put(order.getId(),order);
        writeIntoFile();
    }

    @Override
    public Order getOrderById(Long id) {
        readWithFile();
        return ordersMap.get(id);
    }

    @Override
    public void updateOrderInDatabase(Order order) {
        readWithFile();
        ordersMap.remove(order.getId());
        ordersMap.put(order.getId(),order);
        writeIntoFile();
    }

    @Override
    public void deleteOrderFromDatabase(Order order) {
        readWithFile();
        ordersMap.remove(order.getId());
        writeIntoFile();
    }

    private void readWithFile() {
        try {
            InputStream inputStream = new FileInputStream(file);
            ordersMap = mapper.readValue(inputStream, Map.class);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeIntoFile(){
        try {
            mapper.writeValue(file, ordersMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
