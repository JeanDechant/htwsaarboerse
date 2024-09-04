package com.boerse.models;

public class Stack {
    private int stackId;
    private int portfolioId;
    private int aktieId;
    private int customerId;
    private int sizeOfStack;

    // Constructor, Getters and Setters - WELL WELL WELLL, WHO DO WE HAVE HERE?!

    public Stack(int stackId, int portfolioId, int aktieId, int customerId, int sizeOfStack) {
        this.stackId = stackId;
        this.portfolioId = portfolioId;
        this.aktieId = aktieId;
        this.customerId = customerId;
        this.sizeOfStack = sizeOfStack;
    }

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getAktieId() {
        return aktieId;
    }

    public void setAktieId(int aktieId) {
        this.aktieId = aktieId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSizeOfStack() {
        return sizeOfStack;
    }

    public void setSizeOfStack(int sizeOfStack) {
        this.sizeOfStack = sizeOfStack;
    }
}
