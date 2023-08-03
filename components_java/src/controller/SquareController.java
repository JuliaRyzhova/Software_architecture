package controller;

import model.Square;
import view.SquareView;

/**
 * Класс для связи расчета параметров квадрата и вывода их в консоль
 */
public class SquareController implements IShapeController {
    /**
     * Поле объекта 'квадрат'
     */
    private Square square;
    /**
     * Поле представления объекта 'квадрат'
     */
    private SquareView view;

    /**
     * Конструктор - создание нового экземпляра класса SquareController с заданным объектом 'квадрат' и
     * его представлением
     *
     * @param view   представление объекта 'квадрат'
     * @param square объект 'квадрат'
     */
    public SquareController(SquareView view, Square square) {
        this.view = view;
        this.square = square;
    }

    /**
     * Метод вычисления и отображения площади квадрата
     */
    @Override
    public void getArea() {
        try {
            double area = square.calculateArea();
            view.showArea(area);
        } catch (IllegalArgumentException e) {
            view.showSideError();
        }
    }

    /**
     * Метод вычисления и отображения периметра квадрата
     */
    @Override
    public void getPerimeter() {
        try {
            double perimeter = square.calculatePerimeter();
            view.showPerimeter(perimeter);
        } catch (IllegalArgumentException e) {
            view.showSideError();
        }
    }
}