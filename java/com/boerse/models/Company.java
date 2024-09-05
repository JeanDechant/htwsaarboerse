package com.boerse.models;

public class Company {
    private int companyId;     // Eindeutige ID der Firma
    private String name;       // Name der Firma
    private String kuerzel;    // Börsenkürzel der Firma
    private String land;       // Sitzland der Firma
    private String branche;    // Branche der Firma

    // Konstruktor
    public Company(int companyId, String name, String kuerzel, String land, String branche) {
        this.companyId = companyId;
        this.name = name;
        this.kuerzel = kuerzel;
        this.land = land;
        this.branche = branche;
    }

    // Getter und Setter
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", kuerzel='" + kuerzel + '\'' +
                ", land='" + land + '\'' +
                ", branche='" + branche + '\'' +
                '}';
    }
}
