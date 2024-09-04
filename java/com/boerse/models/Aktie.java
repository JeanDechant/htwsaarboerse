package com.boerse.models;

import java.util.Date;

public class Aktie {
    private int aktieId;
    private int companyId;
    private double cost;
    private Date dayOfCreation;
//	    |	 |
// 	____|____|____
//	    |    |
//	____|____|____
//	    |	 | X
//	    |	 |
//
    public Aktie(int aktieId, int companyId, double cost, Date dayOfCreation) {
        this.aktieId = aktieId;
        this.companyId = companyId;
        this.cost = cost;
        this.dayOfCreation = dayOfCreation;
    }

    public int getAktieId() {
        return aktieId;
    }

    public void setAktieId(int aktieId) {
        this.aktieId = aktieId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDayOfCreation() {
        return dayOfCreation;
    }

    public void setDayOfCreation(Date dayOfCreation) {
        this.dayOfCreation = dayOfCreation;
    }
}
