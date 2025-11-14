//   Создать класс с данными, который имеет вложенный класс Enum, в котором указано количество струн
//   Создать интерфейс src.main.java.Playable с методом play(), который принимает количество струн. Реализуйте этот интерфейс в классах src.main.java.Guitar и src.main.java.Piano.
//   В методе play() выведите сообщение о том, что инструмент играет и сколько использует струн. (Количество струн должно передаваться из вложенного класса Enum)
//   Отравить в комментарий ссылку на merge request, в котором указаны доработки


interface Playable {
    void play(Instrument.StringsQuantity quantity);
}


class Instrument {
    public enum StringsQuantity {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10);

        private final int string;

        StringsQuantity(int string) {
            this.string = string;
        }

        public int getValue() {
            return string;
        }

    }
}


class Guitar extends Instrument implements Playable {
    @Override
    public void play(StringsQuantity quantity) {
        System.out.println("Играет гитара! Количество струн: " + quantity.getValue());
    }
}


class Piano extends Instrument implements Playable {
    @Override
    public void play(StringsQuantity quantity) {
        System.out.println("Играет пианино! Количество струн: " + quantity.getValue());
    }
}


public class Instruments {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        guitar.play(Instrument.StringsQuantity.FIVE);
        piano.play(Instrument.StringsQuantity.TEN);
    }
}