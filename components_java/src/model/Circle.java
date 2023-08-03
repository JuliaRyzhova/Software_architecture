package model;

/**
 * Класс геометрической фигуры 'Круг' наследник интерфейса 'Shape'
 */
public class Circle implements IShape {
    /**
     * Поле радиус круга
     */
    private double radius;

    /**
     * Конструктор - создание нового экземпляра класса Circle
     *
     * @param radius радиус круга
     */
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    /**
     * Метод расчета площади круга
     *
     * @return площадь круга (тип double)
     */
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Метод расчета периметра круга
     *
     * @return периметр круга (тип double)
     */
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}