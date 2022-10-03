package uz.pdp.model.transaction;

import java.math.BigDecimal;

public class Transaction {
    private static long idGeneration = 0;
    private long id = 0;
    private BigDecimal transactionAmount;
    private BigDecimal transactionAmountInCurrency;
    private int merchantId;
    private String transactionAccount;
    private int stateId;

    public Transaction() {
        idGeneration ++;
        this.id = idGeneration;
    }

    public Transaction(int stateId) {
        this();
        this.stateId = stateId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getTransactionAmountInCurrency() {
        return transactionAmountInCurrency;
    }

    public void setTransactionAmountInCurrency(BigDecimal transactionAmountInCurrency) {
        this.transactionAmountInCurrency = transactionAmountInCurrency;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
