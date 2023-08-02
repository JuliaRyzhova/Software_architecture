package controller;

import model.Rectangle;
import view.RectangleView;

/**
 * ����� ��� ����� ������� ���������� �������������� � ������ �� � �������
 */
public class RectangleController implements ShapeController {
    /**
     * ���� ������� '�������������'
     */
    private Rectangle rectangle;
    /**
     * ���� ������������� ������� '�������������'
     */
    private RectangleView view;

    /**
     * ����������� - �������� ������ ���������� ������ RectangleController � �������� �������� '�������������' �
     * ��� ��������������
     *
     * @param view      ������������� ������� '�������������'
     * @param rectangle ������ '�������������'
     */
    public RectangleController(RectangleView view, Rectangle rectangle) {
        this.view = view;
        this.rectangle = rectangle;

    }

    /**
     * ����� ���������� � ����������� ������� ��������������
     */
    @Override
    public void getArea() {
        double area = rectangle.calculateArea();
        view.showArea(area);
    }

    /**
     * ����� ���������� � ����������� ��������� ��������������
     */
    @Override
    public void getPerimeter() {
        double perimeter = rectangle.calculatePerimeter();
        view.showPerimeter(perimeter);
    }
}
