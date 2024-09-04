package com.boerse.models;

public class Portfolio {
    private int portfolioId;
    private int kundenId;
    private int numberOfStock;
    private double completeWorth;

    // I find your lack of faith disturbing. -Darth Vader

    public Portfolio(int portfolioId, int kundenId, int numberOfStock, double completeWorth) {
        this.portfolioId = portfolioId;
        this.kundenId = kundenId;
        this.numberOfStock = numberOfStock;
        this.completeWorth = completeWorth;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    public double getCompleteWorth() {
        return completeWorth;
    }

    public void setCompleteWorth(double completeWorth) {
        this.completeWorth = completeWorth;
    }
}
