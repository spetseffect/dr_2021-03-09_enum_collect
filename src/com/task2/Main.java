package com.task2;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void ShowMenu(){
        System.out.println("""
                1. Добавить нового пользователя;
                2. Удалить существующего пользователя;
                3. Проверить существует ли пользователь;
                4. Изменить логин существующего пользователя;
                5. Изменить пароль существующего пользователя;
                0. Выход.""");
    }
    public static void main(String[] args) {
        ShowMenu();
        try(Scanner sc=new Scanner(System.in)) {
            var map=new HashMap<String,String>();
            while (true) {
                System.out.print("Ваш выбор: ");
                int n = sc.nextInt();
                switch (n) {
                    case 1 -> {
                        System.out.print("Введите логин: ");
                        String login = sc.nextLine();
                        while (map.containsKey(login)) {
                            System.out.println("Пользователь с таким логином уже есть. Повторить попытку?");
                            System.out.println("""
                                    1. Да
                                    2. Нет""");
                            int a=sc.nextInt();
                            if(a==1) {
                                System.out.print("Введите логин: ");
                                login = sc.nextLine();
                            }
                        }
                        System.out.print("Введите пароль: ");
                        String pass = sc.nextLine();
                        if(map.put(login,pass)==null) System.out.println("1 пользователь успешно добавлен.");
                        else System.out.println("УПС! Мы кажется кому-то поменяли пароль.");
                    }
                    case 2 -> {
                        System.out.print("Введите логин пользователя, которого надо удалить: ");
                        String login = sc.nextLine();
                        if (map.containsKey(login)) {
                            map.remove(login);
                            System.out.println("1 пользователь удалён.");
                        }else System.out.println("""
                                    Пользователь с таким логином не существует.
                                    Повторите попытку когда таковой появится.""");
                    }
                    case 3 -> {
                        System.out.print("Введите логин для проверки на наличие: ");
                        String login = sc.nextLine();
                        if (map.containsKey(login)) {
                            System.out.println("Пользователь с таким логином существует.");
                        }else System.out.println("Пользователь с таким логином не существует.");
                    }
                    case 4 -> {
                        System.out.print("Введите логин, который надо изменить: ");
                        String oldLogin = sc.nextLine();
                        if (map.containsKey(oldLogin)) {
                            System.out.print("Введите новый логин: ");
                            String newLogin = sc.nextLine();
                            var val=map.remove(oldLogin);
                            map.put(newLogin,val);
                            System.out.println("Логин изменён.");
                        }else System.out.println("""
                                    Пользователь с таким логином не существует.
                                    Повторите попытку когда таковой появится.""");
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
                try { sleep(1000);}
                catch (InterruptedException e) { e.printStackTrace(); }
                ShowMenu();
            }
        }
    }
}
