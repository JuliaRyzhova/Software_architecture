package boundary_control_entity.data;
import boundary_control_entity.domain.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс InMemoryProductRepository представляет реализацию интерфейса ProductRepository,
 * использующую коллекцию для хранения товаров.
 */
public class InMemoryProductRepository implements ProductRepository {
    private Map<String, Product> products;

    /**
     * Создает новый экземпляр класса InMemoryProductRepository.
     */
    public InMemoryProductRepository() {
        products = new HashMap<>();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(String id) {
        return products.get(id);
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
}