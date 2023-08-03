package model;

/**
 * Абстрактный интерфейс геометрической фигуры
 */
public interface IShape {
    /**
     * Метод расчета площади фигуры
     */
    double calculateArea();

    /**
     * Метод расчета периметра фигуры
     */
    double calculatePerimeter();
}
