package model;

/**
 * ����� �������������� ������ '�������' ��������� ���������� 'Shape'
 */
public class Square implements Shape {
    /**
     * ���� ������� ��������
     */
    private double side;

    /**
     * ����������� - �������� ������ ���������� ������ Square
     *
     * @param side ������� ��������
     */
    public Square(double side) {
        this.side = side;
    }

    /**
     * ����� ������� ������� ��������
     *
     * @return ������� �������� (��� double)
     */
    @Override
    public double calculateArea() {
        return side * side;
    }

    /**
     * ����� ������� ��������� ��������
     *
     * @return �������� �������� (��� double)
     */
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
