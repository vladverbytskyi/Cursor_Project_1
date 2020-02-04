package service;

import model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    boolean createOrderInDatabase(Order order);

    Order getOrderById(Long orderId);

    boolean updateOrderInDatabase(Order order);

    boolean deleteOrderFromDatabase(Order order);
}
