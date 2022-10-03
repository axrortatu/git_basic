package uz.pdp.model.mercahnt;

import uz.pdp.model.Base;

import java.math.BigDecimal;

public class Merchant extends Base {
    private int gatewayMerchantId;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getGatewayMerchantId() {
        return gatewayMerchantId;
    }

    public void setGatewayMerchantId(int gatewayMerchantId) {
        this.gatewayMerchantId = gatewayMerchantId;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isInActive=" + isInActive +
                ", gatewayMerchantId=" + gatewayMerchantId +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                '}';
    }
}
