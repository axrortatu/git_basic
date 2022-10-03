package uz.pdp.distributor.receive;

import java.math.BigDecimal;

public class PaynetCheckReceiveDto implements BaseCheckReceiveDto{
    private String name;
    private String blabla;
    private String transactionAccount;
    private int paynetAgentMerchantId;
    private BigDecimal paynetSum;
    private String token;


    @Override
    public DefaultCheckReceiveDto convert() {
        return new DefaultCheckReceiveDto(
                        token,
                paynetAgentMerchantId,
                transactionAccount,
                paynetSum
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlabla() {
        return blabla;
    }

    public void setBlabla(String blabla) {
        this.blabla = blabla;
    }

    public String getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public int getPaynetAgentMerchantId() {
        return paynetAgentMerchantId;
    }

    public void setPaynetAgentMerchantId(int paynetAgentMerchantId) {
        this.paynetAgentMerchantId = paynetAgentMerchantId;
    }

    public BigDecimal getPaynetSum() {
        return paynetSum;
    }

    public void setPaynetSum(BigDecimal paynetSum) {
        this.paynetSum = paynetSum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
