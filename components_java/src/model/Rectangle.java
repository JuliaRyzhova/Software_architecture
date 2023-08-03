package model;

/**
 * Класс геометрической фигуры 'Прямоугольник' наследник интерфейса 'Shape'
 */
public class Rectangle implements IShape {
    /**
     * Поле длина прямоугольника
     */
    private double length;
    /**
     * Поле ширина прямоугольника
     */
    private double width;

    /**
     * Конструктор - создание нового экземпляра класса Rectangle
     *
     * @param length длина прямоугольника (должна быть положительным числом)
     * @param width  ширина прямоугольника (должна быть положительным числом)
     * @throws IllegalArgumentException (Нельзя вводить числа <= 0)
     */
    public Rectangle(double length, double width) {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("Ширина и длина прямоугольника должны быть положительными числами");
        }
        this.length = length;
        this.width = width;
    }

    /**
     * Метод расчета площади прямоугольника
     *
     * @return площадь прямоугольника (тип double)
     */
    @Override
    public double calculateArea() {
        return length * width;
    }

    /**
     * Метод расчета периметра прямоугольника
     *
     * @return периметр прямоугольника (тип double)
     */
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
