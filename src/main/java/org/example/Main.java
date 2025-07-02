package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String[] names = new String[100];
        String[] phoneNumbers = new String[100];
        int index = 0;
        while (true) {
            System.out.println("Пункты меню:");
            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Просмотреть контакты");
            System.out.println("3 - Найти контакт");
            System.out.println("4 - Удалить контакт");
            System.out.println("5 - Выйти");
            if (!console.hasNextInt()) {
                console.next();
                System.out.println("Требуется ввести число от 1 до 5. Ваше значение некорректное!");
                continue;
            }

            int choice = console.nextInt();
            console.nextLine();
            switch (choice) {
                case 1:
                    if (index < names.length) {
                        System.out.println("Введите имя контакта");
                        names[index] = console.nextLine();
                        System.out.println("Введите контактный номер");
                        phoneNumbers[index] = console.nextLine();

                        System.out.println("Вы успешно добавили контакт: " + names[index] + " Номер: " + phoneNumbers[index]);
                        index = index + 1;
                        break;
                    } else {
                        System.out.println("Невозможно добавить контакт, память заполнена");
                    }
                case 2:

                    if (index == 0) {
                        System.out.println("Список контактов пуст.");
                        continue;
                    } else {
                        for (int i = 0; i < index; i++) {
                            System.out.println("Имя контакта: " + names[i] + " Номер телефона пользователя: " + phoneNumbers[i]);
                        }
                        break;
                    }

                case 3:

                    if (index == 0) {
                        System.out.println("Список контактов пуст.");
                        continue;
                    } else {
                        System.out.println("Введите имя для поиска");
                        String nameSearch = console.nextLine();
                        boolean flag = false;
                        for (int i = 0; i < index; i++) {
                            if (names[i].equals(nameSearch)) {
                                System.out.println("Имя контакта: " + names[i] + " Номер телефона: " + phoneNumbers[i]);
                                flag = true;
                            }

                        }
                        if (!flag) {
                            System.out.println("Контакт не найден");
                            break;
                        }
                    }
                    break;
                case 4:
                    if (index == 0) {
                        System.out.println("Список контактов пуст.");
                        continue;
                    } else {
                        System.out.println("Введите имя для удаления");
                        String nameDel = console.nextLine();
                        boolean contactDeleted = false;

                        for (int i = 0; i < index; i++) {
                            if (names[i].equals(nameDel)) {
                                for (int j = 0; j < index - 1; j++) {
                                    names[j] = names[j + 1];
                                    phoneNumbers[j] = phoneNumbers[j + 1];
                                }
                                names[index - 1] = null;
                                phoneNumbers[index - 1] = null;
                                index = index - 1;
                                contactDeleted = true;
                                System.out.println("Вы успешно удалили контакт");
                                break;
                            }
                        }
                        if (!contactDeleted) {
                            System.out.println("Имя не найдено");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Неверный ввод! Введите число от 1 до 5.");
            }
        }
    }
}

