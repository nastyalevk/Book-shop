package nastya.BookShop.service.interf;

import nastya.BookShop.model.Assortment;

import java.util.List;

public interface AssortmentService {

    List<Assortment> getAssortmentByShop(Integer shopId);
}
