package org.marcossousadev.model.entity;

import java.math.BigDecimal;

public class Personas {
    private int id;
    private String name;
    private String lastname;
    private String middlename;
    private String fullname;
    private BigDecimal salary;
    private int age;

    public Personas(int id, String name, String lastname, String middlename, String fullname, BigDecimal salary, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.middlename = middlename;
        this.fullname = fullname;
        this.salary = salary;
        this.age = age;
    }

    public Personas() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
