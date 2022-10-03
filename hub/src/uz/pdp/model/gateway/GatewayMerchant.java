package uz.pdp.model.gateway;

import uz.pdp.model.Base;

public class GatewayMerchant extends Base {
    private int gatewayId;
    private int merchantId;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }

    @Override
    public String toString() {
        return "GatewayMerchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isInActive=" + isInActive +
                ", gatewayId=" + gatewayId +
                ", merchantId=" + merchantId +
                '}';
    }
}
