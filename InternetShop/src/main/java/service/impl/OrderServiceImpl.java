package service.impl;

import dao.OrderDao;
import dao.OrderDaoFileImpl;
import model.Order;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoFileImpl();

    @Override
    public List<Order> getAllOrders() {
        List<Order> allOrders = orderDao.getAllOrders();
        if (allOrders.isEmpty()) {
            System.out.println("We don't have any Orders");
        }
        return allOrders;
    }

    @Override
    public boolean createOrderInDatabase(Order order) {
        boolean isCreate = false;
        orderDao.createOrderInDatabase(order);
        if (orderDao.getOrderById(order.getId()) != null) {
            isCreate = true;
        }
        return isCreate;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderDao.getOrderById(orderId);
    }

    @Override
    public boolean updateOrderInDatabase(Order order) {
        boolean isUpdate = false;
        orderDao.updateOrderInDatabase(order);
        if (orderDao.getOrderById(order.getId()) != null) {
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean deleteOrderFromDatabase(Order order) {
        boolean isDelete = false;
        orderDao.deleteOrderFromDatabase(order);
        if (orderDao.getOrderById(order.getId()) == null) {
            isDelete = true;
        }
        return isDelete;
    }
}
