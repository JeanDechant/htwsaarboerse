package com.boerse.models;

import java.sql.Timestamp;

public class Transaktion {
    private int transaktionId;
    private int kundenId;
    private int aktieId;
    private int numberOfStock;
    private String sortOfTransaction;
    private String status;
    private double costPerStock;
    private boolean boughtStock;
    private Timestamp time;

    // YOU WERE THE CHOSEN ONE. YOU WERE SUPPOSED TO DESTROY THEM, NOT JOIN THEM!

    public Transaktion(int transaktionId, int kundenId, int aktieId, int numberOfStock, String sortOfTransaction, String status, double costPerStock, boolean boughtStock, Timestamp time) {
        this.transaktionId = transaktionId;
        this.kundenId = kundenId;
        this.aktieId = aktieId;
        this.numberOfStock = numberOfStock;
        this.sortOfTransaction = sortOfTransaction;
        this.status = status;
        this.costPerStock = costPerStock;
        this.boughtStock = boughtStock;
        this.time = time;
    }

    public int getTransaktionId() {
        return transaktionId;
    }

    public void setTransaktionId(int transaktionId) {
        this.transaktionId = transaktionId;
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public int getAktieId() {
        return aktieId;
    }

    public void setAktieId(int aktieId) {
        this.aktieId = aktieId;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    public String getSortOfTransaction() {
        return sortOfTransaction;
    }

    public void setSortOfTransaction(String sortOfTransaction) {
        this.sortOfTransaction = sortOfTransaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCostPerStock() {
        return costPerStock;
    }

    public void setCostPerStock(double costPerStock) {
        this.costPerStock = costPerStock;
    }

    public boolean isBoughtStock() {
        return boughtStock;
    }

    public void setBoughtStock(boolean boughtStock) {
        this.boughtStock = boughtStock;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
