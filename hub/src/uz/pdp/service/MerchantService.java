package uz.pdp.service;

import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.service.base.BaseService;

public class MerchantService implements BaseService {

    public static Merchant[] merchants;
    private static int index = 0;

    public MerchantService(int size){
        merchants = new Merchant[size];
    }

    public static int addMerchant(Merchant merchant){
        merchants[index ++] = merchant;
        return 0;
    }

    @Override
    public boolean add(Object o, Object objService) {
        merchants[index ++] = (Merchant) o;
        return false;
    }

    @Override
    public Object getById(int id) {
        int left = 0, right = index - 1;

        while (left <= right){
            int midd = (left + right)/2;

            if (merchants[midd].getId() == id){
                return merchants[midd];
            }
            if (merchants[midd].getId() > id){
                right = midd - 1;
            }else {
                left = midd + 1;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
