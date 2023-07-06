package ru.geekbrains.api.sem1;

import java.util.Scanner;

public class sem1 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        run();
        
    }

    /** общий метод выполнения задачи 1
     */
    public static void task1() {

        System.out.println("\nВычислить n-ое треугольное число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)");
        System.out.println("\nВведите число n:");

        int n = getInt();
        int sum = sum(n);
        long factorial = factorial(n);

        System.out.printf("\nn-ое треугольное число равно: %d, n!:произведение чисел от 1 до n равно %d\n", sum, factorial);
        System.out.println();

    }

    /** метод для получения числа int задача 1
     */
    public static int getInt(){
        int result = 0;
        boolean flag = true;
        while(flag){
            try {
                result = Integer.parseInt(scan.nextLine());
                if(result <= 0){
                    System.out.println("\nВведите число >=1, ещё раз:");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println("\nНеверный формат ввода, ещё раз:");
            }
        }
        return result;
    }

    /** метод для подсчета суммы чисел, идущих от 1 до n
     */
    public static int sum(int number){
        int result = 0;
        for (int i = 1; i < number + 1; i++) {
            result += i;            
        }
        return result;
    }

    /** метод для подсчета произведения чисел, идущих от 1 до n
     */
    public static long factorial(int number){
        long result = 1;
        for (int i = 1; i < number + 1; i++) {
            result *= i;            
        }
        return result;
    }

    /** метод для выполнения задачи 2
     */
    public static void task2(){
        System.out.println("\nВывести все простые числа от 1 до 1000\n");
        int count = 0;
        for(int i = 1; i <= 1000; i++){
            for(int j = 1; j <= i; j++){
                if (i%j == 0)
                {
                    count++;
                }
            }

            if (count <= 2 )
            {
                System.out.print(i + " ");
            }

            count = 0;
        }
        System.out.println("\n");

    }

    /** метод для ввода числа задачи 3
     */
    public static double getDouble(){
        double result = 0;
        boolean flag = true;
        while(flag){
            try {
                result = Double.parseDouble(scan.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("\nНеверный формат ввода, ещё раз:");
            }
        }
        return result;
    }

    /** метод для выполнения задачи 3
     */
    public static void task3(){

        System.out.println("\nРеализовать простой калькулятор");

        System.out.println("\nВведите первое число:");
        double firstNumber = getDouble();

        System.out.println("\nВведите второе число:");
        double secondNumber = getDouble();
        
        System.out.println("\nВведите действие (+, -, *, /):");
        boolean f3 = true;
        while(f3){
            String operation = scan.nextLine();
            switch (operation) {
                case "+":
                    System.out.println("\nОтвет:");
                    System.out.println(firstNumber + secondNumber);
                    System.out.println();
                    f3 = false;
                    break;
                
                case "-":
                    System.out.println("\nОтвет:");
                    System.out.println(firstNumber - secondNumber);
                    System.out.println();
                    f3 = false;
                    break;

                case "*":
                    System.out.println("\nОтвет:");
                    double result = firstNumber * secondNumber;
                    System.out.println(result);
                    System.out.println();
                    f3 = false;
                    break;
                
                case "/":
                    if (secondNumber == 0) {
                        System.out.println("\nОтвет:");
                        System.out.println("На ноль делить нельзя!");
                    } else {
                        System.out.println("\nОтвет:");
                        result = firstNumber / secondNumber;
                        System.out.println(result);                       
                    }
                    System.out.println();
                    f3 = false;
                    break;    
                
                default:
                    System.out.println("Данная операция отсутствует, ещё раз:");
                    break;
            }
            
        }

    }

    /** метод для запуска приложения или выхода
      */
    public static boolean askForCheck(){

        System.out.println("Продолжить работу с приложением? ");
        System.out.println("1 - продолжить");
        System.out.println("2 - выйти из приложения");
        boolean f1 = true;
        while (f1) {
            String text = scan.nextLine();
            switch(text){                        
                case "1":
                    f1 = false;                    
                    return true;

                case "2":
                    f1 = false;
                    return false;

                default:
                    System.out.println("Вы указали некорректный номер задачи!\nПовторите попытку ввода.");
                    break;
            }
        }
        return true;
    }

    /** метод для запуска консольного приложения
     */
    public static void run(){
        boolean f = true;
        while(f){
            System.out.println("Введите номер задачи:");
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("0 - Завершение работы приложения");
            String number = scan.nextLine();

            switch(number){
                case "1":
                    task1();
                    f = askForCheck();
                    break;

                case "2":
                    task2();
                    f = askForCheck();
                    break;

                case "3":
                    task3();
                    f = askForCheck();    
                    break;
            
                case "0":
                    System.out.println("Завершение работы приложения...");
                    f = false;
                    break;
                
                default:
                    System.out.println("\nВы указали некорректный номер задачи!\nПовторите попытку ввода.");
                break;

            }
        }
    }
}