package com.github.infinitumus.employeeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortEmployee {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void sortMenu() {
        System.out.println("\nВыберите по какому параметру отсортировать список:");
        System.out.println("1. ID");
        System.out.println("2. Дата добавления сотрудника в список");
        System.out.println("3. Имя");
        System.out.println("4. Возраст");
        System.out.println("5. Рост");
        System.out.println("6. Дата рождения");
        System.out.println("7. Место рождения\n");
    }

    public static int sort() throws IOException {
        switch (Integer.parseInt(reader.readLine())) {
            case 1 -> Comparators.compareById();
            case 2 -> Comparators.compareByDate();
            case 3 -> Comparators.compareByName();
            case 4 -> Comparators.compareByAge();
            case 5 -> Comparators.compareByHeight();
            case 6 -> Comparators.compareByBirthDate();
            case 7 -> Comparators.compareByBirthPlace();
            default -> MainMenu.error();
        }
        return 0;
    }
}
