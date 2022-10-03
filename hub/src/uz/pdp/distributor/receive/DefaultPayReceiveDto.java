package uz.pdp.distributor.receive;

public class DefaultPayReceiveDto {
    private long transactionId;
    private String agent;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
