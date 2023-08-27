package com.github.infinitumus.employeeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveLoad {
    public static void saveList() {
        File file = new File(Main.DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(Main.SER_SAVE_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Main.TXT_SAVE_FILE_PATH));
             BufferedWriter logWriter = new BufferedWriter(new FileWriter(Main.LOG_LIST_FILE_PATH, true))) {

            objectOutputStream.writeObject(Main.listEmployees);

            for (Employee employee : Main.listEmployees) {
                writer.write(employee.toString());
                logWriter.write(employee.toString());
                logWriter.flush();
                writer.flush();
                writer.newLine();
                logWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void loadList() {
        File file = new File(Main.SER_SAVE_FILE_PATH);
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                Main.listEmployees = (List<Employee>) objectInputStream.readObject();

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else Main.listEmployees = new ArrayList<>();
    }
}
