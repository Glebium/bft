// За каждый месяц банк начисляет к сумме вклада 7% от суммы. Напишите консольную программу, в которую пользователь вводит сумму вклада и количество месяцев.
// А банк вычисляет конечную сумму вклада с учетом начисления процентов за каждый месяц.
// Для вычисления суммы с учетом процентов используйте цикл for. Пусть сумма вклада будет представлять тип float.
// По аналогии выполните задание используя цикл while


import java.util.Scanner;

public class Deposit {
    final float firstAmount;
    final int months;

    Deposit(float firstAmount, int months) {
        // Проверка на корректность передаваемых значений
        if (months < 1) {
            String monthErrorMessage = "Количество месяцев, на который можно открыть вклад, должно быть больше 0!";
            throw new IllegalArgumentException(monthErrorMessage);
        }
        if (firstAmount < 1) {
            String AmountErrorMessage = "Сумма вклада должна быть больше 0!";
            throw new IllegalArgumentException(AmountErrorMessage);
        }
        this.firstAmount = firstAmount;
        this.months = months;
    }

    float getPayoutWithForLoop() {
        float payout = firstAmount;
        float interest;
        for (int i = 0; i < months; i++) {
            interest = payout * 0.07f;
            payout += interest;
        }
        return payout;
    }

    float getPayoutWithWhileLoop() {
        float payout = firstAmount;
        float interest;
        int i = 0;
        while(i < months) {
            interest = payout * 0.07f;
            payout += interest;
            i++;
        }
        return payout;
    }
}


class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму вклада: ");
        float amount = scanner.nextFloat();
        System.out.print("Введите количество месяцев: ");
        int months = scanner.nextInt();
        Deposit deposit = new Deposit(amount, months);
        System.out.println("Конечная выплата (цикл for): " + deposit.getPayoutWithForLoop());
        System.out.println("Конечная выплата (цикл while): " + deposit.getPayoutWithWhileLoop());
    }
}
