package controller;

import model.Triangle;
import view.TriangleView;

/**
 * Класс для связи расчета параметров треугольника и вывода их в консоль
 */
public class TriangleController implements ShapeController {
    /**
     * Поле объекта 'треугольник'
     */
    private Triangle triangle;
    /**
     * Поле представления объекта 'треугольник'
     */
    private TriangleView view;

    /**
     * Конструктор - создание нового экземпляра класса TriangleController с заданным объектом 'треугольник' и
     * его представлением
     *
     * @param view     представление объекта 'треугольник'
     * @param triangle объект 'треугольник'
     */
    public TriangleController(TriangleView view, Triangle triangle) {
        this.view = view;
        this.triangle = triangle;

    }

    /**
     * Метод вычисления и отображения площади треугольника
     */
    @Override
    public void getArea() {
        double area = triangle.calculateArea();
        view.showArea(area);
    }

    /**
     * Метод вычисления и отображения периметра треугольника
     */

    @Override
    public void getPerimeter() {
        double perimeter = triangle.calculatePerimeter();
        view.showPerimeter(perimeter);
    }
}
