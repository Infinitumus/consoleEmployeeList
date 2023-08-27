package com.github.infinitumus.employeeList;

import java.util.Comparator;

public class Comparators {
    public static Comparator<? super Employee> compareById() {
        Main.listEmployees.sort(Comparator.comparingInt(Employee::getId));
        return Comparator.comparingInt(Employee::getId);
    }

    public static void compareByDate() {
        Main.listEmployees.sort(Comparator.comparing(Employee::getDate).thenComparing(compareById()));
    }
    public static void compareByName() {
        Main.listEmployees.sort(Comparator.comparing(Employee::getName).thenComparing(compareById()));
    }
    public static void compareByAge() {
        Main.listEmployees.sort(Comparator.comparingInt(Employee::getAge).thenComparing(compareById()));
    }
    public static void compareByHeight() {
        Main.listEmployees.sort(Comparator.comparingInt(Employee::getHeight).thenComparing(compareById()));
    }
    public static void compareByBirthDate() {
        Main.listEmployees.sort(Comparator.comparing(Employee::getBirthDate).thenComparing(compareById()));
    }
    public static void compareByBirthPlace() {
        Main.listEmployees.sort(Comparator.comparing(Employee::getBirthPlace).thenComparing(compareById()));
    }
}
