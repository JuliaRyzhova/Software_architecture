package controller;

import model.Square;
import view.SquareView;

/**
 * ����� ��� ����� ������� ���������� �������� � ������ �� � �������
 */
public class SquareController implements ShapeController {
    /**
     * ���� ������� '�������'
     */
    private Square square;
    /**
     * ���� ������������� ������� '�������'
     */
    private SquareView view;

    /**
     * ����������� - �������� ������ ���������� ������ SquareController � �������� �������� '�������' �
     * ��� ��������������
     *
     * @param view   ������������� ������� '�������'
     * @param square ������ '�������'
     */
    public SquareController(SquareView view, Square square) {
        this.view = view;
        this.square = square;
    }

    /**
     * ����� ���������� � ����������� ������� ��������
     */
    @Override
    public void getArea() {
        double area = square.calculateArea();
        view.showArea(area);
    }

    /**
     * ����� ���������� � ����������� ��������� ��������
     */
    @Override
    public void getPerimeter() {
        double perimeter = square.calculatePerimeter();
        view.showPerimeter(perimeter);
    }
}