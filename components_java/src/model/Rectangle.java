package model;

/**
 * ����� �������������� ������ '�������������' ��������� ���������� 'Shape'
 */
public class Rectangle implements Shape {
    /**
     * ���� ����� ��������������
     */
    private double length;
    /**
     * ���� ������ ��������������
     */
    private double width;

    /**
     * ����������� - �������� ������ ���������� ������ Rectangle
     *
     * @param length ����� ��������������
     * @param width  ������ ��������������
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * ����� ������� ������� ��������������
     * @return ������� �������������� (��� double)
     */
    @Override
    public double calculateArea() {
        return length * width;
    }

    /**
     * ����� ������� ��������� ��������������
     *
     * @return �������� �������������� (��� double)
     */
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
