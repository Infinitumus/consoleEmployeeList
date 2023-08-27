package com.github.infinitumus.employeeList;

import java.io.IOException;

public class MainMenu {
    public static Employee employee;

    public static void menu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1. Просмотреть список сотрудников");
        System.out.println("2. Добавить сотрудника");
        System.out.println("3. Редактировать сотрудника");
        System.out.println("4. Удалить сотрудника");
        System.out.println("5. Сортировка списка");
        System.out.println("6. Выход\n");
    }

    public static void exit() {
        SaveLoad.saveList();
        System.exit(0);
    }

    public static void error() {
        System.out.println("\nВыберите корректное значение\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showList() {
        if (Main.listEmployees.isEmpty()) {
            System.out.println("\nСписок пуст\n");
        }
        Main.listEmployees.forEach(System.out::println);
    }

    public static void addEmployeeInList() {
        employee = new Employee();
        ReadEmployee.readName();
        ReadEmployee.readAge();
        ReadEmployee.readHeight();
        ReadEmployee.readBirthDate();
        ReadEmployee.readBirthPlace();
        if (employee.getName() != null && employee.getAge() != 0 && employee.getHeight() != 0 &&
                employee.getBirthDate() != null && employee.getBirthPlace() != null) {
            Main.listEmployees.add(employee);
            SaveLoad.saveList();
        } else System.out.println("\nНекорректные данные\n");
    }

    public static void deleteEmployee() {
        DeleteEmployee.delete();
    }

    public static void editEmployee() throws IOException {
        employee = EditEmployee.getById();
        if (employee == null) {
            return;
        }
        while (true) {
            EditEmployee.editMenu();
            if (EditEmployee.edit() == 1) {
                return;
            }
        }
    }

    public static void sortList() throws IOException {
        SortEmployee.sortMenu();
        SortEmployee.sort();
        System.out.println("\nСписок отсортирован\n");
        showList();
    }
}




