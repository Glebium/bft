public class Plane {
    String boardName;
    int fuel;
    int power;
    int velocity;
    static int quantity;
    Boolean isWheelDown = true;
    private Boolean isLeftTurbineIsTurnedOn = false;
    private Boolean isRightTurbineIsTurnedOn = false;

    Plane(String name) {
        fuel = 0;
        power = 0;
        velocity = 0;
        quantity += 1;       // Метод (конструктор), в котором используется статичная переменная
        boardName = name;
    }

    void turnOnTurbines() {
        if (fuelCheck()) {
            if (!isLeftTurbineIsTurnedOn && !isRightTurbineIsTurnedOn) {
                System.out.println("Левая и правая турбины включены!");
                isLeftTurbineIsTurnedOn = true;
                isRightTurbineIsTurnedOn = true;
                increasePower();
            } else {
                System.out.println("Турбины уже включены!");
            }
        } else {
            System.out.println("Недостаточно топлива для включения турбин!");
        }
    }

    void turnOffTurbines() {
        if (isLeftTurbineIsTurnedOn && isRightTurbineIsTurnedOn) {
            System.out.println("Левая и правая турбины выключены!");
            isLeftTurbineIsTurnedOn = false;
            isRightTurbineIsTurnedOn = false;
        } else {
            System.out.println("Турбины уже выключены!");
        }
    }

    void increasePower() {
        if (power < 100) {
            power += 10;
            System.out.println("Мощность турбин увеличена на 10%! Мощность: " + power);
            velocityController();
        } else {
            System.out.println("Достигнут предел мощности двигателя! Мощность: " + power);
        }
    }

    void velocityController() {
        if (power > 10) {
            velocity = 1000 * power / 100;
            System.out.println("Скорость самолета: " + velocity + " км/ч");
            if (velocity == 200) {
                if (isWheelDown) {
                    isWheelDown = false;
                }
            }
        } else {
            velocity = 0;
            System.out.println("Скорость самолета: " + velocity + " км/ч");
            if (!isWheelDown) {
                isWheelDown = true;
            }
        }
    }

    void decreasePower() {
        if (power > 10) {
            power -= 10;
            System.out.println("Мощность турбин уменьшена на 10%! Мощность: " + power);
            velocityController();
        } else if (power == 10){
            power -= 10;
            System.out.println("Мощность равна нулю!");
            turnOffTurbines();
            velocityController();
        } else {
            System.out.println("Мощность равна нулю и не может быть < 0! ");
        }
    }

    Boolean fuelCheck() {
        if (fuel <= 10) {
            System.out.println("Объем топлива в баке: " + fuel + " %");
            return false;
        } else {
            System.out.println("Объем топлива в баке: " + fuel + " %");
            return true;
        }
    }

    // Метод, в котором используется статичная переменная
    static int getQuantity() {
        System.out.println("На заводе произведено общее кол-во самолетов: " + Plane.quantity);
        return Plane.quantity;
    }
}

class Main {
    public static void main(String[] args) {
        Plane planeOne = new Plane("RUSSIA-825");
        Plane planeTwo = new Plane("CHINA-527");
        Plane planeThree = new Plane("USA-002");
        // Проверяем количество созданных самолетов
        int quantity = Plane.getQuantity(); // На заводе произведено общее кол-во самолетов: 3
        if (quantity > 10) {
            System.out.println("Произведено много самолетов!");
        } else {
            System.out.println("Произведено мало самолетов!");
        }
        // Включаем двигатели первого самлета
        planeOne.turnOnTurbines(); // Объем топлива в баке: 0 % // Недостаточно топлива для включения турбин!
        // Заправляем топливом все самолеты (переопределяем нестатичные переменные)
        planeOne.fuel = 100;
        planeTwo.fuel = 60;
        planeThree.fuel = 10;
        // Включаем двигатели всех самолетов
        planeOne.turnOnTurbines(); // Объем топлива в баке: 100 % // Левая и правая турбины включены! // Мощность турбин увеличена на 10%! Мощность: 10 // Скорость самолета: 0 км/ч
        planeTwo.turnOnTurbines(); // Объем топлива в баке: 60 % // Левая и правая турбины включены! // Мощность турбин увеличена на 10%! Мощность: 10 // Скорость самолета: 0 км/ч
        planeThree.turnOnTurbines(); // Объем топлива в баке: 10 % // Недостаточно топлива для включения турбин!
        // Пробуем включить уже включенный двигатель
        planeOne.turnOnTurbines(); // Объем топлива в баке: 100 % // Турбины уже включены!
        // Проверяем, что шасси не убраны
        System.out.println(planeOne.isWheelDown); // true
        // Увеличиваем мощность двигателя самолета № 1
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 20 // Скорость самолета: 200 км/ч
        // Проверяем, что шасси убрались как только скорость самолета достигла 200 км/ч
        System.out.println(planeOne.isWheelDown); // false
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 30 // Скорость самолета: 300 км/ч
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 40 // Скорость самолета: 400 км/ч
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 50 // Скорость самолета: 500 км/ч
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 60 // Скорость самолета: 600 км/ч
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 70 // Скорость самолета: 700 км/ч
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 80 // Скорость самолета: 800 км/ч
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 90 // Скорость самолета: 900 км/ч
        planeOne.increasePower(); // Мощность турбин увеличена на 10%! Мощность: 100 // Скорость самолета: 1000 км/ч
        planeOne.increasePower(); // Достигнут предел мощности двигателя! Мощность: 100
        // Готовим самолет к посадке
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 90 // Скорость самолета: 900 км/ч
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 80 // Скорость самолета: 800 км/ч
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 70 // Скорость самолета: 700 км/ч
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 60 // Скорость самолета: 600 км/ч
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 50 // Скорость самолета: 500 км/ч
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 40 // Скорость самолета: 400 км/ч
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 30 // Скорость самолета: 300 км/ч
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 20 // Скорость самолета: 200 км/ч
        // Проверяем, что шасси до сих пор убраны
        System.out.println(planeOne.isWheelDown); // false
        planeOne.decreasePower(); // Мощность турбин уменьшена на 10%! Мощность: 10 // Скорость самолета: 0 км/ч
        // Проверяем, что шасси выпущены
        System.out.println(planeOne.isWheelDown); // true
        planeOne.decreasePower(); // Мощность равна нулю! // Левая и правая турбины выключены! // Скорость самолета: 0 км/ч
        planeOne.decreasePower(); // Мощность равна нулю и не может быть < 0!
    }
}
