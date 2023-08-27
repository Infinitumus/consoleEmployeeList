package com.github.infinitumus.employeeList;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class Main {
    public static List<Employee> listEmployees;
    public static String DIR;
    public static String SER_SAVE_FILE_PATH;
    public static  String TXT_SAVE_FILE_PATH;
    public static String LOG_LIST_FILE_PATH;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    static {
        try (FileInputStream fileInputStream= new FileInputStream("src/main/resources/app.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            DIR = properties.getProperty("save.dir");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SER_SAVE_FILE_PATH = DIR + "listEmployees.ser";
        TXT_SAVE_FILE_PATH = DIR + "listEmployees.txt";
        LOG_LIST_FILE_PATH = DIR + "log.txt";
        SaveLoad.loadList();
    }

    public static void main(String[] args) {
        while (true) {
            MainMenu.menu();
            try {
                switch (reader.readLine()) {
                    case "1" -> MainMenu.showList();
                    case "2" -> MainMenu.addEmployeeInList();
                    case "3" -> MainMenu.editEmployee();
                    case "4" -> MainMenu.deleteEmployee();
                    case "5" -> MainMenu.sortList();
                    case "6" -> MainMenu.exit();
                    default -> MainMenu.error();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
