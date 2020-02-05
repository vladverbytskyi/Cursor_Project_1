package dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderDaoFileImpl implements OrderDao {
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file = new File("InternetShop/src/main/java/resource/orders.json");
    private static Map<Long, Order> ordersMap = new LinkedHashMap<>();

    public OrderDaoFileImpl() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    static {
        readWithFile();
        Runtime.getRuntime().addShutdownHook(new Thread(OrderDaoFileImpl::writeIntoFile));
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(ordersMap.values());
    }

    @Override
    public void createOrderInDatabase(Order order) {
        ordersMap.put(order.getId(), order);
    }

    @Override
    public Order getOrderById(Long id) {
        return ordersMap.get(id);
    }

    @Override
    public void updateOrderInDatabase(Order order) {
        ordersMap.remove(order.getId());
        ordersMap.put(order.getId(), order);
    }

    @Override
    public void deleteOrderFromDatabase(Order order) {
        ordersMap.remove(order.getId());
    }

    private static void readWithFile() {
        try {
            InputStream inputStream = new FileInputStream(file);
            Order[] orders = mapper.readValue(inputStream, Order[].class);
            ordersMap = Stream.of(orders).collect(Collectors.toMap(Order::getId, Function.identity()));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeIntoFile() {
        try {
            mapper.writeValue(file, ordersMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
