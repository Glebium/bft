// Добавить классу, в котором создан массив из трех строк генерацию случайного числа от 0 до 2.
// Написать метод, который случайным образом выводит в консоль одну из трех строк.
// Отравить в комментарий ссылку на merge request, в котором указаны доработки


import java.lang.Math;

public class Lib {
    private final String[] array = {"Строка № 1", "Строка № 2", "Строка № 3"};

    private int generateRandomNum() {
        return (int) (Math.random() * 3);
    }

    String showRandomElement() {
        return array[generateRandomNum()];
    }

    public static void main(String[] args) {
        Lib lib = new Lib();
        System.out.println(lib.showRandomElement());
        System.out.println(lib.showRandomElement());
        System.out.println(lib.showRandomElement());
        System.out.println(lib.showRandomElement());
        System.out.println(lib.showRandomElement());
        System.out.println(lib.showRandomElement());
    }
}
