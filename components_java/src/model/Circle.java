package model;

/**
 * ����� �������������� ������ '����' ��������� ���������� 'Shape'
 */
public class Circle implements Shape {
    /**
     * ���� ������ �����
     */
    private double radius;

    /**
     * ����������� - �������� ������ ���������� ������ Circle
     *
     * @param radius ������ �����
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * ����� ������� ������� �����
     *
     * @return ������� ����� (��� double)
     */
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * ����� ������� ��������� �����
     *
     * @return �������� ����� (��� double)
     */
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}