package uz.pdp.model.agent;

import uz.pdp.model.Base;

public class AgentMerchant extends Base {
    private int agentId;
    private int merchantId;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "AgentMerchant{" +
                "agentId=" + agentId +
                ", merchantId=" + merchantId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", isInActive=" + isInActive +
                '}';
    }
}
