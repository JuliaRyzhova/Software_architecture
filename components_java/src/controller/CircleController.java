package controller;

import model.Circle;
import view.CircleView;

/**
 * ����� ��� ����� ������� ���������� ����� � ������ �� � �������
 */
public class CircleController implements ShapeController {
    /**
     * ���� ������� '����'
     */
    private Circle circle;
    /**
     * ���� ������������� ������� '����'
     */
    private CircleView view;


    /**
     * ����������� - �������� ������ ���������� ������ CircleController � �������� �������� '����' �
     * ��� ��������������
     *
     * @param view   ������������� ������� '����'
     * @param circle ������ '����'
     */
    public CircleController(CircleView view, Circle circle) {
        this.view = view;
        this.circle = circle;

    }

    /**
     * ����� ���������� � ����������� ������� �����
     */
    @Override
    public void getArea() {
        double area = circle.calculateArea();
        view.showArea(area);
    }

    /**
     * ����� ���������� � ����������� ��������� �����
     */

    @Override
    public void getPerimeter() {
        double perimeter = circle.calculatePerimeter();
        view.showPerimeter(perimeter);
    }
}
