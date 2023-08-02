package model;

/**
 * Класс геометрической фигуры 'Прямоугольник' наследник интерфейса 'Shape'
 */
public class Rectangle implements Shape {
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
     * @param length длина прямоугольника
     * @param width  ширина прямоугольника
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Метод расчета площади прямоугольника
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
