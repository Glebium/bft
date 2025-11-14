//     Создайте класс src.main.java.Employee с полями name и salary.
//     Создайте подклассы src.main.java.Manager и src.main.java.Developer, которые наследуют от src.main.java.Employee.
//     Добавьте метод work() в каждом классе, который выводит сообщение о работе сотрудника.
//     Создайте абстрактный класс src.main.java.Shape с абстрактным методом draw().
//     Создайте подклассы src.main.java.Circle и src.main.java.Rectangle, которые реализуют метод draw().
//     В методе draw() выведите сообщение о том, что фигура рисуется.
//     Отравить в комментарий ссылку на merge request, в котором указаны доработки


public class Employee {
    String name;
    int salary;
}

class Manager extends Employee {
    Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    void work() {
        System.out.println(this.name + " работает!");
    }
}

class Developer extends Employee {
    Developer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    void work() {
        System.out.println(this.name + " работает!");
    }
}


abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape{
    public void draw() {
        System.out.println("Рисуется круг!");
    }
}

class Rectangle {
    public void draw() {
        System.out.println("Рисуется прямоугольник!");
    }
}


// Проверка работы
class Main4 {
    public static void main(String[] args) {
        Manager manager = new Manager("Вася", 20000);
        Developer developer = new Developer("Петя", 25000);
        manager.work();     // Вася работает!
        developer.work();   // Петя работает!

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        circle.draw();      // Рисуется круг!
        rectangle.draw();   // Рисуется прямоугольник!
    }
}
