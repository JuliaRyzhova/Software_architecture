package controller;

import model.Rectangle;
import view.RectangleView;

/**
 * Класс для связи расчета параметров прямоугольника и вывода их в консоль
 */
public class RectangleController implements IShapeController {
    /**
     * Поле объекта 'прямоугольник'
     */
    private Rectangle rectangle;
    /**
     * Поле представления объекта 'прямоугольник'
     */
    private RectangleView view;

    /**
     * Конструктор - создание нового экземпляра класса RectangleController с заданным объектом 'прямоугольник' и
     * его представлением
     *
     * @param view      представление объекта 'прямоугольник'
     * @param rectangle объект 'прямоугольник'
     */
    public RectangleController(RectangleView view, Rectangle rectangle) {
        this.view = view;
        this.rectangle = rectangle;

    }

    /**
     * Метод вычисления и отображения площади прямоугольника
     */
    @Override
    public void getArea() {
        double area = rectangle.calculateArea();
        view.showArea(area);
    }

    /**
     * Метод вычисления и отображения периметра прямоугольника
     */
    @Override
    public void getPerimeter() {
        double perimeter = rectangle.calculatePerimeter();
        view.showPerimeter(perimeter);
    }
}
