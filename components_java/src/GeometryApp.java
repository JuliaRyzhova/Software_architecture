import controller.CircleController;
import controller.RectangleController;
import controller.SquareController;
import controller.TriangleController;
import model.Circle;
import model.Rectangle;
import model.Square;
import model.Triangle;
import view.CircleView;
import view.RectangleView;
import view.SquareView;
import view.TriangleView;

/**
 * Главный класс `GeometryApp` служит точкой входа для приложения и связывает все компоненты вместе:
 * 1. Необходимо создать экземпляр конкретной геометрической фигуры(модель), например круг
 * 2. Необходимо создать экземпляр класса представления(вью) этой фигуры
 * 3. Необходимо создать экземпляр контроллера этой фигуры
 * 4. Через экземпляр класса контроллера вывести необходимые методы
 */
public class GeometryApp {

    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        CircleView circleView = new CircleView();
        CircleController circleController = new CircleController(circleView, circle);
        circleController.getArea();
        circleController.getPerimeter();

        Rectangle rectangle = new Rectangle(4, 6);
        RectangleView rectangleView = new RectangleView();
        RectangleController rectangleController = new RectangleController(rectangleView, rectangle);
        rectangleController.getArea();
        rectangleController.getPerimeter();

        Triangle triangle = new Triangle(3, 4, 5);
        TriangleView triangleView = new TriangleView();
        TriangleController triangleController = new TriangleController(triangleView, triangle);
        triangleController.getArea();
        triangleController.getPerimeter();

        Square square = new Square(5);
        SquareView squareView = new SquareView();
        SquareController squareController = new SquareController(squareView, square);
        squareController.getArea();
        squareController.getPerimeter();

    }
}
