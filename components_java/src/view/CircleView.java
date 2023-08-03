package view;

/**
 * Класс представления параметров круга в консоли, наследник интерфейса ShapeView
 */
public class CircleView implements IShapeView {
    /**
     * Метод для вывода площади круга в консоль
     *
     * @param area площадь круга
     */
    @Override
    public void showArea(double area) {
        System.out.println("Площадь круга: " + area);
    }

    /**
     * Метод для вывода периметра круга в консоль
     *
     * @param perimeter периметр круга
     */
    @Override
    public void showPerimeter(double perimeter) {
        System.out.println("Периметр круга: " + perimeter);
    }
}
