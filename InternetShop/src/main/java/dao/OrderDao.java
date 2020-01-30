package dao;

import model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();

    void createOrderInDatabase(Order order);

    Order getOrderById(Long id);

    void updateOrderInDatabase(Order order);

    void deleteOrderFromDatabase(Order order);
}
