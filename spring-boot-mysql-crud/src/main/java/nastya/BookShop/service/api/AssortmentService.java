package nastya.BookShop.service.api;

import nastya.BookShop.model.Assortment;

import java.util.List;

public interface AssortmentService {

    List<Assortment> getAssortmentByShop(Integer id);
}
