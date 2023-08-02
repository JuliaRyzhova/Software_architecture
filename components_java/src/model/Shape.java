package model;

/**
 * Абстрактный класс геометрической фигуры
 */
public interface Shape {
    /**
     * Метод расчета площади фигуры
     *
     * @return площадь фигуры
     */
    double calculateArea();

    /**
     * Метод расчета периметра фигуры
     *
     * @return периметр фигуры
     */
    double calculatePerimeter();
}
