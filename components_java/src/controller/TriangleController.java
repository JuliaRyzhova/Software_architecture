package controller;

import model.Triangle;
import view.TriangleView;

/**
 * ����� ��� ����� ������� ���������� ������������ � ������ �� � �������
 */
public class TriangleController implements ShapeController {
    /**
     * ���� ������� '�����������'
     */
    private Triangle triangle;
    /**
     * ���� ������������� ������� '�����������'
     */
    private TriangleView view;

    /**
     * ����������� - �������� ������ ���������� ������ TriangleController � �������� �������� '�����������' �
     * ��� ��������������
     *
     * @param view     ������������� ������� '�����������'
     * @param triangle ������ '�����������'
     */
    public TriangleController(TriangleView view, Triangle triangle) {
        this.view = view;
        this.triangle = triangle;

    }

    /**
     * ����� ���������� � ����������� ������� ������������
     */
    @Override
    public void getArea() {
        double area = triangle.calculateArea();
        view.showArea(area);
    }

    /**
     * ����� ���������� � ����������� ��������� ������������
     */

    @Override
    public void getPerimeter() {
        double perimeter = triangle.calculatePerimeter();
        view.showPerimeter(perimeter);
    }
}
