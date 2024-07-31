import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // определяем новый сканер
        Scanner sc = new Scanner(System.in);
        String input;
        // while, чтобы после каждой успешной операции программа не завершалась
        while (true) {
            // запрашиваем ввод у пользователя
            System.out.println("Введите арифметическое выражение в одну строку через пробел: ");
            input = sc.nextLine();
            // обработка исключений
            try {
                String result = calc(input);
                // выводим результат арифметической операции
                System.out.println("Результат: " + result);
            // "Отлавливаем ошибки"
            } catch
            (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
                // чтобы после любой ошибки программа завершилась
                System.exit(1);
            }
        }
    }

    public static String calc(String input) throws Exception {
        // разбиваем строку на массив
        String[] parts = input.split(" ");
        // проверяем количество элементов массиве (должно быть не больше 3х - 2 операнда и 1 оператор)
        if (parts.length != 3) {
            throw new Exception("Некорректный формат выражения");
        }
        // преобразуем элементы массивы в числа
        int a = Integer.parseInt(parts[0]);
        // преобразуем элемент массива оператор в символ
        char operator = parts[1].charAt(0);
        int b = Integer.parseInt(parts[2]);

        // проверяем чтобы вводимые числа были от 1 до 10
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        int result;
        // производим вычисления
        switch (operator){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new Exception("Неподдерживаемая операция");
        }
        // преобразуем результат из числа в строку и возвращаем в метод
        return Integer.toString(result);
    }
}