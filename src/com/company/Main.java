package com.company;

import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("1. Добавить элемент в список;\n" +
                "2. Удалить элемент из списка;\n" +
                "3. Показать содержимое списка;\n" +
                "4. Проверить есть ли значение в списке;\n" +
                "5. Заменить значение в списке;\n" +
                "0. Выход.");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] s=str.split(",\s?");
        ArrayList<Integer> arr=new ArrayList<>();
        for (String i :s)
            arr.add(Integer.valueOf(i));
        ShowMenu();
        Integer n=-1;
        while (!n.equals(0)) {
            n = sc.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.print("Введите число: ");
                    Integer k = sc.nextInt();
                    arr.add(k);
                }
                case 2 -> {
                    System.out.print("Введите порядковый номер(отсчёт с 1) элемента, который надо удалить: ");
                    int i = sc.nextInt();
                    System.out.println("Элемент с индексом " + (i - 1) +
                            " и значением " + ((int) arr.remove(i - 1)) + " удалён.");
                    ArrToConsole(arr);
                }
                case 3 -> {
                    ArrToConsole(arr);
                }
                case 4 -> {
                    System.out.print("Введите значение, которое будем искать: ");
                    int i = sc.nextInt();
                    System.out.print("Элемент с таким значением ");
                    if(arr.contains(i)) System.out.println("есть.");
                    else System.out.println("отсутствует.");
                }
                case 5 -> {
                }
                default -> {
                    System.out.println("Выход.");
                    return;
                }
            }
            ShowMenu();
        }
        sc.close();
    }
}
