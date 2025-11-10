package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1 = readNumber(sc, "Введите первое число");
        char operator = readOperator(sc, "Введите математический оператор (+, -, /, *)");
        double num2 = readNumber(sc, "Введите второе число");

        Double answer = calculate(num1, num2, operator);

        if (answer != null) {
            System.out.printf("Ответ: %.2f%n", answer);
        }
        sc.close();
    }

    public static double readNumber(Scanner sc, String msg) {

        while (true) {
            System.out.println(msg);
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный формат числа, введите число в формате 123.45");
                sc.nextLine();
            }
        }
    }

    public static char readOperator(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            String operator = sc.next();
            if (operator.length() == 1 && isOperator(operator.charAt(0))) {
                return operator.charAt(0);
            } else {
                System.out.println("Некорректный оператор, введите оператор из списка");
            }
        }
    }

    public static boolean isOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    public static Double calculate(double num1, double num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Ошибка деления на ноль!!");
                    yield null;
                } else {
                    yield num1 / num2;
                }
            }
            default -> {
                System.out.println("Ошибка - неизвестная операция");
                yield null;
            }
        };
    }
}