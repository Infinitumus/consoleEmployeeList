package com.github.infinitumus.employeeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadEmployee {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static void readName() {
        while (true) {
            System.out.println("\nВведите имя\n");
            try {
                MainMenu.employee.setName(reader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("\nПопробуйте еще раз\n");
            }
        }
    }

    static void readAge() {
        while (true) {
            System.out.println("\nВведите возраст\n");
            try {
                MainMenu.employee.setAge(Integer.parseInt(reader.readLine()));
                break;
            } catch (Exception e) {
                System.out.println("\nПопробуйте еще раз\n");
            }
        }
    }

    static void readHeight() {
        while (true) {
            System.out.println("\nВведите рост\n");
            try {
                MainMenu.employee.setHeight(Integer.parseInt(reader.readLine()));
                break;
            } catch (Exception e) {
                System.out.println("\nПопробуйте еще раз\n");
            }
        }
    }

    static void readBirthPlace() {
        while (true) {
            System.out.println("\nВведите место рождения\n");
            try {
                MainMenu.employee.setBirthPlace(reader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("\nПопробуйте еще раз\n");
            }
        }
    }

    static void readBirthDate() {
        while (true) {
            System.out.println("\nВведите дату рождения, пример ввода: 1960-08-30\n");
            try {
                MainMenu.employee.setBirthDate(reader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("\nПопробуйте еще раз\n");
            }
        }
    }
}
