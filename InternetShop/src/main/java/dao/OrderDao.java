package dao;

import model.Order;
import model.Product;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();

    void createOrderInDatabase(Order order);

    Order getOrderById(Long id);

    void updateOrderInDatabase(Order order);

    void deleteOrderFromDatabase(Order order);
}
