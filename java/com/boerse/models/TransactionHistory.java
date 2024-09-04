package com.boerse.models;

public class TransactionHistory {
    private int transactionId;

    // Constructor
    public TransactionHistory(int transactionId) {
        this.transactionId = transactionId;
    }

    // Getter and Setter for transactionId
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
