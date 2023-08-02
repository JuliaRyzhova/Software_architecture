package controller;

import model.Circle;
import view.CircleView;

/**
 * Класс для связи расчета параметров круга и вывода их в консоль
 */
public class CircleController implements ShapeController {
    /**
     * Поле объекта 'круг'
     */
    private Circle circle;
    /**
     * Поле представления объекта 'круг'
     */
    private CircleView view;


    /**
     * Конструктор - создание нового экземпляра класса CircleController с заданным объектом 'круг' и
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
        double area = circle.calculateArea();
        view.showArea(area);
    }

    /**
     * Метод вычисления и отображения периметра круга
     */

    @Override
    public void getPerimeter() {
        double perimeter = circle.calculatePerimeter();
        view.showPerimeter(perimeter);
    }
}
