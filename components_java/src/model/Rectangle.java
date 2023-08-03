package model;

/**
 * Класс геометрической фигуры 'Прямоугольник' наследник интерфейса 'Shape'
 */
public class Rectangle implements IShape {
    /**
     * Поле длина прямоугольника
     */
    private double lenght;
    /**
     * Поле ширина прямоугольника
     */
    private double width;

    /**
     * Конструктор - создание нового экземпляра класса Rectangle
     *
     * @param lenght длина прямоугольника (должна быть положительным числом)
     * @param width  ширина прямоугольника (должна быть положительным числом)
     * @throws IllegalArgumentException (Нельзя вводить числа <= 0)
     */
    public Rectangle(double lenght, double width) {
        if (width <= 0 || lenght <= 0) {
            throw new IllegalArgumentException("Ширина и длина прямоугольника должны быть положительными числами");
        }
        this.lenght = lenght;
        this.width = width;
    }

    /**
     * Метод расчета площади прямоугольника
     *
     * @return площадь прямоугольника (тип double)
     */
    @Override
    public double calculateArea() {
        return lenght * width;
    }

    /**
     * Метод расчета периметра прямоугольника
     *
     * @return периметр прямоугольника (тип double)
     */
    @Override
    public double calculatePerimeter() {
        return 2 * (lenght + width);
    }
}
