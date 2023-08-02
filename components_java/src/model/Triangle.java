package model;


/**
 * ����� �������������� ������ '�����������' ��������� ���������� 'Shape'
 */
public class Triangle implements Shape {
    /**
     * ���� 1-�� ������� ����������
     */
    private double side1;
    /**
     * ���� 2-�� ������� ������������
     */
    private double side2;
    /**
     * ���� 3-� ������� ������������
     */
    private double side3;

    /**
     * �������� ������ ���������� ������ Triangle
     * @param side1 ����� ������ ������� ������������
     * @param side2 ����� ������ ������� ������������
     * @param side3 ����� ������� ������� ������������
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * ����� ������� ������� ������������
     * @return ������� ������������ (��� double)
     */
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * ����� ������� ��������� ������������
     * @return �������� ������������ (��� double)
     */
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}