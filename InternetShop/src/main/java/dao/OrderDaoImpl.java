package dao;

import model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {
    private static Map<Long, Order> orders = new HashMap<>();

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList(orders.values());
    }

    @Override
    public void createOrderInDatabase(Order order) {
        orders.put(order.getId(), order);
        System.out.println("Order " + order.getId() + " added to the database");
    }

    @Override
    public Order getOrderById(Long id) {
        return orders.get(id);
    }

    @Override
    public void updateOrderInDatabase(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void deleteOrderFromDatabase(Order order) {
        orders.remove(order.getId(), order);
    }
}
