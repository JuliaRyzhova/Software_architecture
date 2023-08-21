package org.example.agregator;

/**
 * Класс Order представляет заказ, который состоит из одного или нескольких продуктов (элементов заказа).
 * Этот класс агрегирует в себе несколько объектов OrderItem, что соответствует паттерну "Агрегатор".
 *
 * В контексте паттерна "Агрегатор", данный класс играет роль "Контейнера", который собирает в себе
 * несколько объектов, предоставляя удобный интерфейс для работы с ними.
 */


import java.util.ArrayList;
import java.util.List;

public class Order {

    // Список элементов заказа
    private List<OrderItem> items;

    /**
     * Конструктор, инициализирующий пустой список элементов заказа.
     */
    public Order() {
        this.items = new ArrayList<>();
    }

    /**
     * Геттер для получения списка элементов заказа.
     *
     * @return список элементов заказа
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Сеттер для установки списка элементов заказа.
     *
     * @param items список элементов заказа
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Метод для добавления элемента заказа в текущий заказ.
     *
     * @param item элемент заказа для добавления
     */
    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    /**
     * Метод для расчета общей стоимости заказа, учитывая цену и количество каждого продукта.
     *
     * @return общая стоимость заказа
     */
    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
