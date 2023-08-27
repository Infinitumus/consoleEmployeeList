package com.github.infinitumus.employeeList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Externalizable {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    @Serial
    private static final long serialVersionUID = 1000001L;
    private static int countId = 1;
    private int id;
    private LocalDate date;
    private String name;
    private int age;
    private int height;
    private LocalDate birthDate;
    private String birthPlace;

    public Employee() {
        this.id = Employee.countId++;
        this.date = LocalDate.now();
    }



    public Employee(String name, int age, int height, LocalDate birthDate, String birthPlace) {
        this.id = Employee.countId++;
        this.date = LocalDate.now();
        this.name = name;
        this.age = age;
        this.height = height;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "id = " + id + " | date = " + dateTimeFormatter.format(date) + " | name = " + name + " | age = " + age + " | height = " + height +
                " | birthDate = " + dateTimeFormatter.format(birthDate) + " | birthPlace = " + birthPlace;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(countId);
        out.writeInt(this.getId());
        out.writeObject(this.getDate());
        out.writeObject(this.getName());
        out.writeObject(this.getAge());
        out.writeObject(this.getHeight());
        out.writeObject(this.getBirthDate());
        out.writeObject(this.getBirthPlace());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        countId = (int) in.readObject();
        this.id = in.readInt();
        this.date = (LocalDate) in.readObject();
        this.name = (String) in.readObject();
        this.age = (int) in.readObject();
        this.height = (int) in.readObject();
        this.birthDate = (LocalDate) in.readObject();
        this.birthPlace = (String) in.readObject();
    }
}
