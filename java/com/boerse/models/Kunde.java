package com.boerse.models;

public class Kunde {
    private int kundenId;        // ID des Kunden
    private String name;         // Name des Kunden
    private String password;     // Passwort für die Authentifizierung
    private double guthaben;     // Verfügbares Guthaben des Kunden
    private double kredit;       // Kreditlimit des Kunden
    private boolean isAdmin;     // Gibt an, ob der Kunde ein Admin ist

    // Konstruktor ohne Adminstatus
    public Kunde(int kundenId, String name, String password, double guthaben, double kredit) {
        this.kundenId = kundenId;
        this.name = name;
        this.password = password;
        this.guthaben = guthaben;
        this.kredit = kredit;
        this.isAdmin = false; // Standardmäßig kein Admin
    }

    // Konstruktor mit Adminstatus
    public Kunde(int kundenId, String name, String password, double guthaben, double kredit, boolean isAdmin) {
        this.kundenId = kundenId;
        this.name = name;
        this.password = password;
        this.guthaben = guthaben;
        this.kredit = kredit;
        this.isAdmin = isAdmin;
    }

    // Getter und Setter
    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(double guthaben) {
        this.guthaben = guthaben;
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundenId=" + kundenId +
                ", name='" + name + '\'' +
                ", guthaben=" + guthaben +
                ", kredit=" + kredit +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
