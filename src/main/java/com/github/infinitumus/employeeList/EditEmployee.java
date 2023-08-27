package com.github.infinitumus.employeeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditEmployee {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void editMenu() {
        System.out.println("\nВыберите параметр для редактирования:");
        System.out.println("1. Имя");
        System.out.println("2. Возраст");
        System.out.println("3. Рост");
        System.out.println("4. Дата рождения");
        System.out.println("5. Место рождения");
        System.out.println("6. Выход\n");
    }

    public static Employee getById() {
        Employee employee;
        System.out.println("\nВведите id или имя сотрудника для редактирования\n");
        while (true) {
            int id;
            String name = null;
            try {
                name = reader.readLine();
                id = Integer.parseInt(name);
                for (Employee emp : Main.listEmployees) {
                    if (emp.getId() == id) {
                        employee = emp;
                        return employee;
                    }
                }
            } catch (Exception e) {
                for (Employee emp : Main.listEmployees) {
                    if (emp.getName().equalsIgnoreCase(name)) {
                        employee = emp;
                        return employee;
                    }
                }
            }
            System.out.println("\nСотрудника с таким id нет в списке\n");
            break;
        }
        return null;
    }

    public static int edit() throws IOException {
        switch (Integer.parseInt(reader.readLine())) {
            case 1 -> ReadEmployee.readName();
            case 2 -> ReadEmployee.readAge();
            case 3 -> ReadEmployee.readHeight();
            case 4 -> ReadEmployee.readBirthDate();
            case 5 -> ReadEmployee.readBirthPlace();
            case 6 -> {
                SaveLoad.saveList();
                return 1;
            }
            default -> MainMenu.error();
        }
        return 0;
    }
}
