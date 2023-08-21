/**
 * Класс OrderService представляет службу для работы с заказами.
 * Этот класс предоставляет бизнес-логику для создания, извлечения и обработки заказов.
 *
 * В контексте паттерна "Агрегатор", данный класс служит мостом между пользовательским интерфейсом
 * и базой данных, делегируя операции с базой данных репозиторию заказов.
 */
package org.example.agregator;

import java.sql.SQLException;

public class OrderService {

    // Репозиторий для работы с заказами в базе данных
    private OrderRepository repository;

    /**
     * Конструктор класса OrderService.
     *
     * @param repository Репозиторий для работы с заказами в базе данных.
     */
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод для создания и сохранения заказа в базе данных.
     *
     * @param order Объект заказа, который необходимо сохранить.
     * @throws SQLException Если возникнет проблема с базой данных.
     */
    public void createOrder(Order order) throws SQLException {
        // Дополнительная логика создания заказа может быть реализована здесь, например, валидация данных заказа
        repository.save(order);
    }

    /**
     * Метод для получения заказа по его идентификатору.
     *
     * @param id Идентификатор заказа.
     * @return Объект заказа или null, если заказ не найден.
     * @throws SQLException Если возникнет проблема с базой данных.
     */
    public Order getOrderById(int id) throws SQLException {
        return repository.getById(id);
    }

    // Другие методы для работы с заказами могут быть добавлены здесь.
    // Например, методы для обновления заказа, удаления заказа, получения списка всех заказов и так далее.
}
