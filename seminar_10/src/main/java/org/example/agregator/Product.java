/**
 * Класс Product представляет продукт, который может быть добавлен в заказ.
 * Этот класс содержит информацию о продукте, такую как идентификатор, название и стоимость.
 */
package org.example.agregator;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private double price;

    /**
     * Конструктор класса Product.
     *
     * @param id    Идентификатор продукта.
     * @param name  Название продукта.
     * @param price Стоимость продукта.
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}