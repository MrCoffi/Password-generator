import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Registration registration = new Registration();
        Scanner s = new Scanner(System.in);
        System.out.printf("""
                Основной функционал:
                   0 - выход из программыss
                   REG <Введите логин> - Генерация пароля
                   GET - Получить все логины/пароли\n""");
        for (; ; ) {
            String input = s.nextLine();
            if (input.contains("0")) {
                System.out.println("Осуществлен выход из програмы...");
                break;
            } else if (input.contains("REG")) {
                input = input.replaceFirst("REG ", "");
                registration.randomPassword(input);
                System.out.println();
            } else if (input.contains("GET")) {
                System.out.println(registration.getData());
            }
        }
    }
}
