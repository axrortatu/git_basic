package uz.pdp.service;

import uz.pdp.model.gateway.Gateway;
import uz.pdp.service.base.BaseService;

public class GatewayService implements BaseService {

    public static Gateway[] gateways;
    private static int index = 0;

    public GatewayService(int size) {
        gateways = new Gateway[size];
    }

    public GatewayService() {
    }


    @Override
    public boolean add(Object o, Object objService) {
        gateways[index++] = (Gateway)o;

        return true;
    }

    @Override
    public Object getById(int id) {
        for (Gateway gateway : gateways) {
            if (gateway != null) {
                if (gateway.getId() == id) {
                    return gateway;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        int var1 = 0;
        for (Gateway gateway : gateways) {
            if (gateway != null) {
                if (gateway.getId() == id) {
                    gateway.setInActive(true);
                    gateways[var1] = gateway;
                    return true;
                }
            }
            var1++;
        }
        return false;
    }
}
