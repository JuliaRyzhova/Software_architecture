/**
 * Класс OrderItem представляет элемент заказа. Элемент заказа включает в себя продукт
 * и количество этого продукта в заказе.
 *
 * В контексте паттерна "Агрегатор", данный класс является одним из составных частей заказа (Order).
 * Он служит для представления информации о конкретном продукте и его количестве в заказе.
 */
package org.example.agregator;

public class OrderItem {

    // Продукт, на который ссылается данный элемент заказа
    private Product product;

    // Количество продукта в заказе
    private int quantity;

    /**
     * Конструктор, создающий элемент заказа на основе продукта и его количества.
     *
     * @param product  Продукт, который необходимо добавить в заказ
     * @param quantity Количество продукта в заказе
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Геттер для получения продукта, связанного с данным элементом заказа.
     *
     * @return продукт, связанный с элементом заказа
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Сеттер для установки продукта для данного элемента заказа.
     *
     * @param product Продукт, который необходимо связать с элементом заказа
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Геттер для получения количества продукта в данном элементе заказа.
     *
     * @return количество продукта в элементе заказа
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Сеттер для установки количества продукта в элементе заказа.
     *
     * @param quantity Количество продукта, которое необходимо установить для элемента заказа
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}