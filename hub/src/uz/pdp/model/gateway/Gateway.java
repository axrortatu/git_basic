package uz.pdp.model.gateway;

import uz.pdp.model.Base;

public class Gateway extends Base {


    public boolean isUcell(){
        return id == 2;
    }

    public boolean isBeeline(){
        return id == 101;
    }

    public boolean isPaynet(){
        return id == 3;
    }

    @Override
    public String toString() {
        return "Gateway{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isInActive=" + isInActive +
                '}';
    }
}
