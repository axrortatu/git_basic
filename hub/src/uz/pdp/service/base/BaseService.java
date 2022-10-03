package uz.pdp.service.base;

public interface BaseService {
    boolean add(Object o, Object objService);
    Object getById(int id);
    boolean deleteById(int id);
}
