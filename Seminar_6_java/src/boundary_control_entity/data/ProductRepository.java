package boundary_control_entity.data;

// ProductRepository.java


import boundary_control_entity.domain.Product;
import java.util.List;

/**
 * Интерфейс ProductRepository определяет методы для управления товарами в интернет-магазине.
 */
public interface ProductRepository {
    /**
     * Получает все товары из репозитория.
     *
     * @return список всех товаров.
     */
    List<Product> getAllProducts();

    /**
     * Получает товар по его идентификатору из репозитория.
     *
     * @param id идентификатор товара.
     * @return товар с указанным идентификатором или null, если товар не найден.
     */
    Product getProductById(String id);

    /**
     * Добавляет новый товар в репозиторий.
     *
     * @param product товар для добавления.
     */
    void addProduct(Product product);
}