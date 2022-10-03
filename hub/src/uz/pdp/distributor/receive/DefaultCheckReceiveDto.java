package uz.pdp.distributor.receive;

import java.math.BigDecimal;

public class DefaultCheckReceiveDto implements BaseCheckReceiveDto {
    private String secretKey;
    private int merchantId;
    private String transactionAccount;
    private BigDecimal transactionAmount;

    public DefaultCheckReceiveDto() {
    }

    public DefaultCheckReceiveDto(String secretKey, int merchantId, String transactionAccount, BigDecimal transactionAmount) {
        this.secretKey = secretKey;
        this.merchantId = merchantId;
        this.transactionAccount = transactionAccount;
        this.transactionAmount = transactionAmount;
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

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public boolean isFull(){
        return transactionAccount != null &&
                transactionAmount != null &&
                secretKey != null &&
                merchantId > 0;
    }

    @Override
    public DefaultCheckReceiveDto convert() {
        return this;
    }
}
