package model;

/**
 * Класс геометрической фигуры 'Квадрат' наследник интерфейса 'Shape'
 */
public class Square implements IShape {
    /**
     * Поле сторона квадрата
     */
    private double side;

    /**
     * Конструктор - создание нового экземпляра класса Square
     *
     * @param side сторона квадрата
     */
    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона круга должна быть быть положительным числом");
        }
        this.side = side;
    }

    /**
     * Метод расчета площади квадрата
     *
     * @return площадь квадрата (тип double)
     */
    @Override
    public double calculateArea() {
        return side * side;
    }

    /**
     * Метод расчета периметра квадрата
     *
     * @return периметр квадрата (тип double)
     */
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
