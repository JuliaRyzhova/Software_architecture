package view;

/**
 * Класс представления параметров квадрата в консоли, наследник интерфейса ShapeView
 */
public class SquareView implements IShapeView {
    /**
     * Метод для вывода площади квадрата в консоль
     *
     * @param area площадь квадрата
     */
    @Override
    public void showArea(double area) {
        System.out.println("Площадь квадрата: " + area);
    }

    /**
     * Метод для вывода периметра квадрата в консоль
     *
     * @param perimeter периметр квадрата
     */
    @Override
    public void showPerimeter(double perimeter) {
        System.out.println("Периметр квадрата: " + perimeter);
    }

    /**
     * Метод для вывода ошибки некорректного значения стороны квадрата
     */
    public void showSideError() {
        System.out.println("Ошибка: некорректное значение стороны квадрата! Сторона квадрата должна быть положительным числом");
    }
}
