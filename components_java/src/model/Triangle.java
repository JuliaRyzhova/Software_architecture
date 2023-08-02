package model;


/**
 * Класс геометрической фигуры 'Треугольник' наследник интерфейса 'Shape'
 */
public class Triangle implements Shape {
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
     * @param side1 длина первой стороны треугольника
     * @param side2 длина второй стороны треугольника
     * @param side3 длина третьей стороны треугольника
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Метод расчета площади треугольника
     * @return площадь треугольника (тип double)
     */
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Метод расчета периметра треугольника
     * @return периметр треугольника (тип double)
     */
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}