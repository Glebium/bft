//• Создать класс Car, с полями model, year, и методом makeBeBe
//• Создать несколько экземпляров класса Сar, переопределить переменные и результат работы метода makeBeBe
//• Отправить в комментарий ссылку на merge request, в котором указана доработка

public class Car {
    private String model;
    private int year;

    Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    Car() {
        this("Москвич", 1946);
    }

    void makeBeBe() {
        System.out.println("Beeeeee! Beeeeee!");
    }

    void makeBeBe(String someString) {
        System.out.println("Биииии! Бииииии!");
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}

class Main2 {
    public static void main(String[] args) {
        Car car1 = new Car("Lada", 2025);
        Car car2 = new Car("BMW", 2025);
        Car car3 = new Car();
        car2.setModel("BMW X5");
        car2.setYear(2000);

        // Проверяем, что для Car2 переопределили переменные model и year
        System.out.println("Car2 model: " + car2.getModel()); // Car2 model: BMW X5
        System.out.println("Car2 year: " + car2.getYear());   // Car2 year: 2000

        // Проверяем, что для Car1 переменные остались такими же, как были указаны в аргументах при создании объекта
        System.out.println("Car1 model: " + car1.getModel()); // Car1 model: Lada
        System.out.println("Car1 year: " + car1.getYear());   // Car1 year: 2025

        // Проверяем работу перегрузки конструктора. Если не указали аргументы при создании экземпляра класса,
        // то создаем машину с моделью "Москвич" с годом выпуска: 1946
        System.out.println("Car3 model: " + car3.getModel()); // Car3 model: Москвич
        System.out.println("Car3 year: " + car3.getYear());   // Car3 year: 1946

        // Проверка работы перегрузки метода:
        // Если не передается аргумент, печатаем гудок на латинице
        // Если передаем аргумент типа String, печатаем гудок на кириллице
        car1.makeBeBe();                                      // Beeeeee! Beeeeee!
        car1.makeBeBe("!");                         // Биииии! Бииииии!

    }
}
