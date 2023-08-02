package view;

/**
 *  Интерфейс для представления геометрических фигур
 */
public interface ShapeView {
    /**
     * Метод вывода на консоль площади фигуры
     */
    public void showArea(double area);

    /**
     * Метод вывода на консоль периметра фигуры
     */
    public void showPerimeter(double perimeter);
}