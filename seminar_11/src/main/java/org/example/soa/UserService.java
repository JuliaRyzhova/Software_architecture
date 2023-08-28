package org.example.soa;

public class UserService {
    public String getUserInfo(int userId) {
        // Здесь бы происходило обращение к базе данных или другому сервису для получения информации о пользователе
        return "User info for ID " + userId;
    }
}

// OrderService.java
public class OrderService {
    public String getOrderDetails(int orderId) {
        // Здесь бы происходило обращение к базе данных или другому сервису для получения информации о заказе
        return "Order details for ID " + orderId;
    }
}

// MainApp.java
public class MainApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        int userId = 123;
        int orderId = 456;

        String userInfo = userService.getUserInfo(userId);
        String orderDetails = orderService.getOrderDetails(orderId);

        System.out.println(userInfo);
        System.out.println(orderDetails);
    }
}