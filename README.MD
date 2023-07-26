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
