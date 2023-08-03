package controller;

import model.Circle;
import view.CircleView;

/**
 * Класс для связи расчета параметров круга и вывода их в консоль
 */
public class CircleController implements IShapeController {
    /**
     * Поле объекта 'круг'
     */
    private Circle circle;
    /**
     * Поле представления объекта 'круг'
     */
    private CircleView view;


    /**
     * Конструктор - создание нового экземпляра класса CircleController с заданным объектом 'прямоугольник' и
     * его представлением
     *
     * @param view   представление объекта 'круг'
     * @param circle объект 'круг'
     */
    public CircleController(CircleView view, Circle circle) {
        this.view = view;
        this.circle = circle;

    }

    /**
     * Метод вычисления и отображения площади круга
     */
    @Override
    public void getArea() {
        try {
            double area = circle.calculateArea();
            view.showArea(area);
        } catch (IllegalArgumentException e) {
            view.showRadiusError();
        }
    }

    /**
     * Метод вычисления и отображения периметра круга
     */

    @Override
    public void getPerimeter() {
        try {
            double perimeter = circle.calculatePerimeter();
            view.showPerimeter(perimeter);
        } catch (IllegalArgumentException e) {
            view.showRadiusError();
        }
    }
}
