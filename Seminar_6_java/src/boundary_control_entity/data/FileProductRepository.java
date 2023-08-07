package boundary_control_entity.data;

// FileProductRepository.java

import boundary_control_entity.domain.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс FileProductRepository представляет реализацию интерфейса ProductRepository,
 * использующую файл для хранения товаров.
 */
public class FileProductRepository implements ProductRepository {
    private String filePath;

    /**
     * Создает новый экземпляр класса FileProductRepository.
     *
     * @param filePath путь к файлу, в котором будут храниться товары.
     */
    public FileProductRepository(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Получает все товары из файла.
     *
     * @return список всех товаров.
     */
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            products = (List<Product>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    /**
     * Получает товар по его идентификатору из файла.
     *
     * @param id идентификатор товара.
     * @return товар с указанным идентификатором или null, если товар не найден.
     */
    @Override
    public Product getProductById(String id) {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Добавляет новый товар в файл.
     *
     * @param product товар для добавления.
     */
    @Override
    public void addProduct(Product product) {
        List<Product> products = getAllProducts();
        products.add(product);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}