package nastya.BookShop.service.api;

import nastya.BookShop.dto.Assortment.AssortmentDto;

import java.util.List;

public interface AssortmentService {

    List<AssortmentDto> getAssortmentByShop(Integer id);

}
