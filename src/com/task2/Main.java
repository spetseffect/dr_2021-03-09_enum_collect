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
                sc.nextLine();
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
                            }else break;
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
                        System.out.print("Введите логин пользователя, пароль которому надо изменить: ");
                        String login = sc.nextLine();
                        if (map.containsKey(login)) {
                            System.out.print("Введите старый пароль: ");
                            String oldPass = sc.nextLine();
                            System.out.print("Введите новый пароль: ");
                            String newPass = sc.nextLine();
                            System.out.print("Повторите новый пароль: ");
                            String newPass2 = sc.nextLine();
                            if(oldPass.equals(map.get(login)) && newPass.equals(newPass2)) {
                                map.put(login, newPass);
                                System.out.println("Пароль изменён.");
                            }else System.out.println("""
                                    Не верный старый пароль или новый пароль и его подтверждение не совпадают.
                                    Повторите попытку позже.""");
                        }else System.out.println("""
                                    Пользователь с таким логином не существует.
                                    Повторите попытку когда таковой появится.""");
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
    }
}
