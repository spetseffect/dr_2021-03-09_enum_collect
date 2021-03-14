package com.task1;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void ArrToConsole(ArrayList<Integer> arr){
        if(!arr.isEmpty()) {
            String str = "";
            for (Integer i : arr) {
                if (str.length() > 0)
                    str = String.join(", ", str, i.toString());
                else str=i.toString();
            }
            System.out.println(str);
        }else System.out.println("ArrayList is empty.");
    }
    public static void ShowMenu(){
        System.out.println("""
                1. Добавить элемент в список;
                2. Удалить элемент из списка;
                3. Показать содержимое списка;
                4. Проверить есть ли значение в списке;
                5. Заменить значение в списке;
                0. Выход.""");
    }

    public static void main(String[] args) {
        System.out.println("Введите список целых чисел через запятую (пробелы допустимы):");
        try(Scanner sc=new Scanner(System.in)) {
            String str = sc.nextLine();
            String[] s = (str.trim()).split("\s?,\s?");
            ArrayList<Integer> arr = new ArrayList<>();
            for (String i : s)
                arr.add(Integer.valueOf(i));
            ShowMenu();
            while (true) {
                int n = sc.nextInt();
                switch (n) {
                    case 1 -> {
                        System.out.print("Введите число: ");
                        Integer k = sc.nextInt();
                        arr.add(k);
                    }
                    case 2 -> {
                        System.out.print("Введите порядковый номер(отсчёт с 1) элемента, который надо удалить: ");
                        int i = sc.nextInt() - 1;
                        if (i < 1 || i > arr.size()) {
                            System.out.println("Ошибка: выход за пределы списка. Повторите попытку.");
                            ShowMenu();
                            continue;
                        }
                        System.out.println("Элемент с индексом " + (i) +
                                " и значением " + (arr.remove(i)) + " удалён.");
                    }
                    case 3 -> ArrToConsole(arr);
                    case 4 -> {
                        System.out.print("Введите значение, которое будем искать: ");
                        int i = sc.nextInt();
                        System.out.print("Элемент с таким значением ");
                        if (arr.contains(i)) System.out.println("есть.");
                        else System.out.println("отсутствует.");
                    }
                    case 5 -> {
                        System.out.print("Введите порядковый номер(отсчёт с 1) элемента, который надо изменить: ");
                        int i = sc.nextInt() - 1;
                        if (i < 1 || i > arr.size()) {
                            System.out.println("Ошибка: выход за пределы списка. Повторите попытку.");
                            ShowMenu();
                            continue;
                        }
                        System.out.print("Введите новое значение: ");
                        int v = sc.nextInt();
                        var tmp = arr.get(i);
                        if (tmp.equals(arr.set(i, v))) System.out.println("Изменено успешно.");
                        else System.out.println("Изменение почему-то не удалось.");
                    }
                    default -> {
                        System.out.println("Выход...");
                        return;
                    }
                }
                System.out.print("\n");
                try { sleep(1000);}//без try/catch работать не хочет
                catch (InterruptedException e) { e.printStackTrace(); }
                ShowMenu();
            }
        }
//        sc.close();
    }
}
