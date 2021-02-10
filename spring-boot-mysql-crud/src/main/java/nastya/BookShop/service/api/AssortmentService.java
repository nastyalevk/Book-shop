package nastya.BookShop.service.api;

import nastya.BookShop.dto.Assortment.AssortmentDto;

import java.text.ParseException;
import java.util.List;

public interface AssortmentService {

    int getPriceByBookShop(Integer bookId, Integer shopId);

    AssortmentDto save(AssortmentDto assortmentDto) throws ParseException;

    boolean existsByBook(Integer bookId, Integer shopId);

    void delete(Integer bookId, Integer shopId) throws ParseException;

    AssortmentDto getOne(Integer bookId, Integer shopId);

    List<AssortmentDto> getByBook(Integer bookId);


}
