package nastya.BookShop.service.interf;

import nastya.BookShop.model.Assortment;

import java.util.Optional;

public interface AssortmentService {

    Optional<Assortment> getAssortmentByShop(Integer shopId);
}
