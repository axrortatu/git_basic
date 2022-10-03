package uz.pdp.service;

import uz.pdp.model.gateway.Gateway;
import uz.pdp.model.gateway.GatewayMerchant;
import uz.pdp.service.base.BaseService;

public class GatewayMerchantService implements BaseService {
    public static GatewayMerchant[] gatewayMerchants;
    private static int index = 0;

    public GatewayMerchantService(int size){
        gatewayMerchants = new GatewayMerchant[size];
    }

    public GatewayMerchant getGatewayMerchant(int gatewayMerchantId){
        for (GatewayMerchant gatewayMerchant: gatewayMerchants) {
            if (gatewayMerchant != null) {
                if (gatewayMerchant.getId() == gatewayMerchantId) {
                    return gatewayMerchant;
                }
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o, Object objService) {
        GatewayMerchant gatewayMerchant = (GatewayMerchant) o;
        GatewayService gatewayService = (GatewayService) objService;
        Gateway gateway = (Gateway) gatewayService.getById(gatewayMerchant.getGatewayId());
        if (gateway == null){
            return false;
        }
        gatewayMerchants[index ++] = gatewayMerchant; // Gateway merchantni qo'shdik
        return true;
    }


    @Override
    public Object getById(int id) {
        int cnt = 0;

        for (GatewayMerchant gatewayMerchant: gatewayMerchants) {
            if (gatewayMerchant != null){
                if (gatewayMerchant.getGatewayId() == id){
                    cnt ++;
                }
            }
        }
        GatewayMerchant[] gatewayMerchantList = new GatewayMerchant[cnt];
        cnt = 0;
        for (GatewayMerchant gatewayMerchant: gatewayMerchants) {
            if (gatewayMerchant != null){
                if (gatewayMerchant.getGatewayId() == id){
                    gatewayMerchantList[cnt ++] = gatewayMerchant;
                }
            }
        }
        return gatewayMerchantList;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
