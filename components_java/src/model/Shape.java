package model;

/**
 * јбстрактный класс геометрической фигуры
 */
public interface Shape {
    /**
     * ћетод расчета площади фигуры
     *
     * @return площадь фигуры
     */
    double calculateArea();

    /**
     * ћетод расчета периметра фигуры
     *
     * @return периметр фигуры
     */
    double calculatePerimeter();
}
