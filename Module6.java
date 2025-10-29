//    Создать массив из 3-х строк (привет, ПОКА, гипербола)
//    Вывести в консоль первую строку из массива в верхнем регистре
//    Вывести вторую строку из массива в нижнем регистре
//    Вывести из массива строку, в которой вторая буква будет «О», а между третьей и четвертой буквой будет «пробел»
//    Отравить в комментарий ссылку на merge request, в котором указаны доработки


public class Module6 {
    public static void main(String[] args) {
        String[] array = {"привет", "ПОКА", "гипербола"};
        System.out.println(array[0].toUpperCase()); // ПРИВЕТ
        System.out.println(array[1].toLowerCase()); // пока
        String changed_word = array[2].replace("и", "О");
        System.out.println(changed_word.substring(0, 3) + " " + changed_word.substring(3)); // гОп ербола
    }
}
