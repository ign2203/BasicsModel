package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Вспоминаем старое домашние задание по теме Basics, которое я не сдал на проверку ментору
         */
        Scanner console = new Scanner(System.in);// создаем сканнер для возможности ввода
        String[] names = new String[100];// создаем обычный массив, из 100 элементов для names
        String[] phoneNumbers = new String[100];// создаем обычный массив, из 100 элементов для phoneNumbers
        int index = 0; // создаем переменную contact, которая сперва равна нулю после, мы будем ее прибавлять когда будем добавлять контакт
        while (true) {// создаем цикл, где выход из цикла будет false, но он будет по логике в 5й кнопке
            System.out.println("Пункты меню:");// создаем меню  Пункты меню:
            System.out.println("1 - Добавить контакт"); //1 - Добавить контакт"
            System.out.println("2 - Просмотреть контакты"); // 2 - Просмотреть контакты
            System.out.println("3 - Найти контакт"); //3 - Найти контакт
            System.out.println("4 - Удалить контакт");// 4 - Удалить контакт
            System.out.println("5 - Выйти"); // 5 - Выйти
            if (!console.hasNextInt()) {
                console.next();
                System.out.println("Требуется ввести число от 1 до 5. Ваше значение некорректное!");
                continue;
            }

            int choice = console.nextInt(); // создаем переменную choice, чтобы пользователь смог попасть в нужный пункт меню, после будем нырять в кейсы
            console.nextLine();// // если я не ошибаюсь,  console.nextLine() ловит  enter console.next(), GPT  проверь меня
            switch (choice) {// создаем switch, где choice будет пункт меню
                case 1:// первый кейс добавить контакты
                    if (index < names.length) {// создаем условие, если количество контактов, меньше любого из массива, то проводим операцию по добавлению
                        System.out.println("Введите имя контакта");// сперва запрашиваем  имя
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

                    if (index == 0) { // создаем второй кес по выводу контактов
                        System.out.println("Список контактов пуст.");  //  создаем условия, если переменная contact = нулю, то список отсутствует
                        continue;                    // continue - возвращаемся в начало цикла, поправь меня GPT, если не прав
                    } else {         // иначе
                        for (int i = 0; i < index; i++) {         // через for проходимся по всем контактам
                            System.out.println("Имя контакта: " + names[i] + " Номер телефона пользователя: " + phoneNumbers[i]);  // и выводим имя и номер
                        }
                        break;
                    }

                case 3: // кейс для поиска контактов

                    if (index == 0) {
                        System.out.println("Список контактов пуст."); // если contact равен 0, что список контактов пуст
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
                        System.out.println("Список контактов пуст."); // если contact равен 0, что список контактов пуст
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
                    continue;
            }
        }
    }
}


// для чего мы ранее пытались ловить неверный ввод пользователем, не понятно.Он по факту даже не работает, неверный ввод улетает в кейс default
// что тоже работает
                    /*
                    Эта часть кода сильно лишняя, GPT или я не прав?
                    if (!console.hasNextInt()) { // здесь нужно ввести логику, неправильного ввода
                console.next();
                System.out.println("Требуется ввести число от 1 до 5. Ваше значение некорректное!");
                continue;
                     */

// выход из программы, через большую реализацию break

