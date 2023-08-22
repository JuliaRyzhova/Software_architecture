package org.example.repository;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String connectionString = "jdbc:sqlite:products.db";
        ProductRepository productRepository = new SQLiteProductRepository(connectionString);

        // Создаем таблицу "products" при запуске
        productRepository.createTable();

        // Создаем продукт
        Product newProduct = new Product(1, "Новый продукт", 19.99);

        // Добавляем продукт в базу данных
        productRepository.add(newProduct);

        // Получаем продукт по ID
        Product retrievedProduct = productRepository.getById(1);
        if (retrievedProduct != null) {
            System.out.println("Получен продукт: " + retrievedProduct.getName());
        }

        // Получаем все продукты
        List<Product> allProducts = productRepository.getAll();
        for (Product product : allProducts) {
            System.out.println("Продукт: " + product.getName());
        }
    }
}