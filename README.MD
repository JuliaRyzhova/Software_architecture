# Урок 1 (Введение в понятие архитектуры, проектирование ПО и жизненный цикл программного продукта. UML-диаграммы)
### Задание:
На основе Диаграмы классов ModelElements, разработать классы: Model Store, PoligonalModel (Texture, Poligon), Flash, Camera, Scene (Реализовать диограмму на любом языке программирования)

![Диаграмма](https://i.ibb.co/BcJ54zT/2023-07-21-08-02-28.png)


Решение по [этой ссылке](https://github.com/JuliaRyzhova/Software_architecture/tree/main/Lesson_1)

# Урок 2 (Объектно-ориентированные паттерны)

**Паттерны** - это часто встречающиеся решения конкретной проблемы при проектировании архитектуры ПО.

Паттерны делятся на 3 категории:

* *Порождающие (generating)* - Отвечают за удобное и безопасное создание новых объектов или даже целых семейств объектов.
* *Структурные (structural)* - Отвечают за построение удобных в поддержке иерархий классов.
* *Поведенческие (behavioral)* - Решают задачи эффективного и безопасного взаимодействия между объектами программы.

![Порождающие паттерны](https://i.ibb.co/Wntg2VJ/2023-07-25-08-44-34.png)

![Структурные паттерны](https://i.ibb.co/r0jm9Jc/2023-07-25-08-46-16.png)

![Поведенческие паттерны](https://i.ibb.co/pzG6dWx/2023-07-25-08-47-08.png)

***Реализация на python***:

Порождающие (generating_patterns):

* [Строитель (builder)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/generating_patterns/builder.py)
* [Фабричный метод (factory_method)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/generating_patterns/factory_method.py)
* [Прототип (prototip)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/generating_patterns/prototip.py)
* [Одиночка (singlton)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/generating_patterns/singlton.py)

Структурные (structural_patterns):

* [Компоновщик (composite)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/structural_patterns/сomposite.py)
* [Адаптер (Adapter)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/structural_patterns/adapter.py)
* [Мост (bridge)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/structural_patterns/bridge.py)
* [Декоратор (decorator)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/structural_patterns/decorator.py)
* [Фасад (facade)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/structural_patterns/facade.py)

Поведенческие (behavioral_patterns):

* [Наблюдатель (observer)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/Seminar_2/behavioral_patterns/observer.py)
* [Цепочка ответственности (chain of responsibility)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/OOP_patterns/behavioral_patterns/chain_of_responsibility.py)
* [Команда (command)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/OOP_patterns/behavioral_patterns/command.py)
* [Итератор (iterator)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/OOP_patterns/behavioral_patterns/iterator.py)
* [Шаблонный метод (template_method)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/OOP_patterns/behavioral_patterns/template_method.py)
* [Посетитель (visitor)](https://github.com/JuliaRyzhova/Software_architecture/blob/main/OOP_patterns/behavioral_patterns/visitor.py)

# Урок 3 (Принципы SOLID)

![Принципы SOLID](https://i.ibb.co/WgLf2g3/2023-07-27-09-49-42.png)

1. [SRP](https://github.com/JuliaRyzhova/Software_architecture/blob/main/SOLID/1_SRP) Single responsibility principle (Принцип единственной ответственности)  - Каждый класс должен выполнять строго обозначенную функцию, т.е. быть ограничен только своей задачей.

2. [OCP](https://github.com/JuliaRyzhova/Software_architecture/blob/main/SOLID/2_OCP) Open-closed principle - Принцип открытости\закрытости. Классы должны быть открыты для расширения и закрыты для модификации. Т.е. должна быть возможность добавлять новый свойства и расширять класс без изменения внутренней реализации существующих свойств.

3. [LSP](https://github.com/JuliaRyzhova/Software_architecture/blob/main/SOLID/3_LSP) Liskov substitution principle - Принцип подстановки Лескова. Подклассы должны заменять свои базовые классы. Дочерний класс должен полностью повторять функционал своего базового класса. Т.е. мы можем через дочерний класс вызвать любой метод базового класса и ожидать от него точно такого же поведения, какое у него было если мы его вызываем непосредственно из базового класса.

4.  [ISP](https://github.com/JuliaRyzhova/Software_architecture/blob/main/SOLID/4_ISP) Interface segregation principle - Принцип разделения интерфейса. Нужно создавать узкоспециализированные интерфейсы, предназначенные для конкретного клиента. Клиенты не должны реализовывать интерфейсы, которые они не используют. Не нужно создавать один интерфейс, реализующий много методов - т.к. все эти методы должны быть реализованы в дочерних классах, а они им могут быть не нужны. Проще создать несколько узкоспециализированных интерфейсов с одним методом для соответствующих классов.

5. [DIP](https://github.com/JuliaRyzhova/Software_architecture/blob/main/SOLID/5_DIP) Dependency inversion principle - Принцип инверсии зависимостей. Наши классы должны зависеть от интерфейсов или абстрактных классов, а не конкретных классов и функций.


# Урок 4 (Компоненты. Принципы связности и сочетаемости компонентов)

Вам необходимо доработать код, добавив контракты к методам, документацию и обеспечив высокую связанность и низкую сочетаемость:

```
// Класс для геометрических фигур
abstract class Shape {
    // Общие поля и методы для всех геометрических фигур
    abstract double getArea();
    abstract double getPerimeter();
}

// Класс для круга
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Класс для прямоугольника
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getArea() {
        return length * width;
    }

    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }
}

// Класс для треугольника
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }
}

// Главный класс приложения
public class GeometryApp {
    public static void main(String[] args) {
        // Пример использования конкретных классов геометрических фигур
        Circle circle = new Circle(5.0);
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Периметр круга: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
    }
}
```
[Реализация на языке Java]https://github.com/JuliaRyzhova/Software_architecture/tree/main/components_java/src) 
