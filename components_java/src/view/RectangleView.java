package view;

/**
 * Класс представления параметров прямоугольника в консоли, наследник интерфейса ShapeView
 */
public class RectangleView implements ShapeView {
    /**
     * Метод для вывода площади прямоугольника в консоль
     *
     * @param area площадь прямоугольника
     */
    @Override
    public void showArea(double area) {
        System.out.println("Площадь прямоугольника: " + area);
    }

    /**
     * Метод для вывода периметра прямоугольника в консоль
     *
     * @param perimeter периметр прямоугольника
     */
    @Override
    public void showPerimeter(double perimeter) {
        System.out.println("Периметр прямоугольника: " + perimeter);
    }
}
