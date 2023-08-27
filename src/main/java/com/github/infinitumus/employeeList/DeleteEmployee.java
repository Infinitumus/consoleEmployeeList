package com.github.infinitumus.employeeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeleteEmployee {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void delete() {
        Employee employee;
        while (true) {
            int id;
            String name = null;
            boolean isDeleted = false;
            System.out.println("\nВведите id или имя сотрудника для удаления из списка\n");
            try {
                name = reader.readLine();
                id = Integer.parseInt(name);
                for (int i = 0; i < Main.listEmployees.size(); i++) {
                    employee = Main.listEmployees.get(i);
                    if (employee.getId() == id) {
                        Main.listEmployees.remove(employee);
                        isDeleted = true;
                    }
                }
            } catch (Exception e) {
                for (int i = 0; i < Main.listEmployees.size(); i++) {
                    employee = Main.listEmployees.get(i);
                    if (employee.getName().equalsIgnoreCase(name)) {
                        Main.listEmployees.remove(employee);
                        isDeleted = true;
                    }
                }
            }

            if (isDeleted) {
                System.out.println("\nСотрудник удален\n");
            } else {
                System.out.println("\nТакого сотрудника нет в списке\n");
            }
            break;
        }
    }
}
