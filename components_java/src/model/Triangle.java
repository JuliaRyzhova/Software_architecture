package model;


/**
 * Класс геометрической фигуры 'Треугольник' наследник интерфейса 'Shape'
 */
public class Triangle implements IShape {
    /**
     * Поле 1-ая сторона треугольна
     */
    private double side1;
    /**
     * Поле 2-ая сторона треугольника
     */
    private double side2;
    /**
     * Поле 3-я сторона треугольника
     */
    private double side3;

    /**
     * создание нового экземпляра класса Triangle
     *
     * @param side1 длина первой стороны треугольника (должна быть положительным числом)
     * @param side2 длина второй стороны треугольника (должна быть положительным числом)
     * @param side3 длина третьей стороны треугольника (должна быть положительным числом)
     * @throws IllegalArgumentException (Нельзя вводить числа <= 0)
     */
    public Triangle(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Метод расчета площади треугольника
     *
     * @return площадь треугольника (тип double)
     */
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Метод расчета периметра треугольника
     *
     * @return периметр треугольника (тип double)
     */
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}