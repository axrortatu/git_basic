package uz.pdp.model.agent;

import uz.pdp.model.Base;

public class Agent extends Base {
    private String secretKey;
    private double commission;


    public boolean isBeeline(){
        return secretKey.equals("beeline123");
    }

    public boolean isPaynet(){
        return secretKey.equals("blablabla");
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission/100;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "secretKey='" + secretKey + '\'' +
                ", commission=" + commission +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", isInActive=" + isInActive +
                '}';
    }
}
