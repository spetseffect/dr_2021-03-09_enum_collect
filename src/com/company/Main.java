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
        Scanner scS=new Scanner(System.in);
        String str=scS.nextLine();
        scS.close();
        String[] s=str.split(",\s?");
        ArrayList<Integer> arr=new ArrayList<>();
        for (String i :s)
            arr.add(Integer.valueOf(i));
        ArrToConsole(arr);
        ShowMenu();
        Scanner scN=new Scanner(System.in);
        Integer n=scN.nextInt();
        switch (n){
            case 1: {
                System.out.print("Введите число: ");
                Integer k=scN.nextInt();
                arr.add(k);
                break;
            }
            case 2:break;
            case 3:break;
            case 4:break;
            case 5:break;
            default: System.out.println("Выход.");
        }
        scN.close();
    }
}
