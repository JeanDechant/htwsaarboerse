package com.boerse.models;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String IBAN;

    // Constructor, Getter, Setter und better. oder bedder... badder... worse... much much worse

    public Person(int id, String name, String surname, String IBAN) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.IBAN = IBAN;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}
