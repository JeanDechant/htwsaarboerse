package com.boerse.models;

public class Kunde {
    private int kundenId;
    private int personId;
    private String passwort;
    private double guthaben;
    private double credit;

    // Wer dies findet, darf es behalten

    public Kunde(int kundenId, int personId, String passwort, double guthaben, double credit) {
        this.kundenId = kundenId;
        this.personId = personId;
        this.passwort = passwort;
        this.guthaben = guthaben;
        this.credit = credit;
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public double getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(double guthaben) {
        this.guthaben = guthaben;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
