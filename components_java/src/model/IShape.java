package model;

/**
 * Абстрактный интерфейс геометрической фигуры
 */
public interface IShape {
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
