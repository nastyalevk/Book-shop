package nastya.BookShop.service.impl;

import nastya.BookShop.dto.Assortment.AssortmentDto;
import nastya.BookShop.model.Assortment;
import nastya.BookShop.model.AssortmentId;
import nastya.BookShop.repository.AssortmentRepository;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.repository.ClassificationRepository;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.service.api.AssortmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class AssortmentServiceImpl implements AssortmentService {

    private final AssortmentRepository assortmentRepository;
    private final BookRepository bookRepository;
    private final ShopRepository shopRepository;
    private final ClassificationRepository classificationRepository;

    @Autowired
    public AssortmentServiceImpl(AssortmentRepository assortmentRepository, BookRepository bookRepository,
                                 ShopRepository shopRepository, ClassificationRepository classificationRepository) {
        this.assortmentRepository = assortmentRepository;
        this.bookRepository = bookRepository;
        this.shopRepository = shopRepository;
        this.classificationRepository = classificationRepository;
    }

    @Override
    public List<AssortmentDto> getAssortmentByShop(Integer id) {
        List<Assortment> assortments = assortmentRepository.findAllByAssortmentIdShopId(id);
        List<AssortmentDto> assortmentDtos = new ArrayList<>();
        for (Assortment i : assortments) {
            assortmentDtos.add(transfer(i));
        }
        return assortmentDtos;
    }

    @Override
    public int getMinPrice(Integer bookId) {
        List<Assortment> assortments =
                assortmentRepository.findAssortmentByAssortmentIdBookId(bookId);
        List<Integer> prices = new ArrayList<>();
        for (Assortment i : assortments) {
            prices.add(i.getPrice());
        }
        Collections.sort(prices);
        return prices.get(0);
    }

    @Override
    public int getPriceByBookShop(Integer bookId, Integer shopId) {
        AssortmentDto assortmentDto =
                transfer(assortmentRepository.findByAssortmentIdBookIdAndAssortmentIdShopId(bookId, shopId));
        return assortmentDto.getPrice();
    }

    @Override
    public AssortmentDto save(AssortmentDto assortmentDto) throws ParseException {
        return transfer(assortmentRepository.save(transfer(assortmentDto)));
    }

    @Override
    public boolean existsByBook(Integer bookId, Integer shopId) {
        return assortmentRepository.existsByAssortmentId(new AssortmentId(bookRepository.getOne(bookId),
                shopRepository.getOne(shopId)));
    }

    @Override
    public void delete(Integer bookId, Integer shopId) throws ParseException {
        assortmentRepository.deleteByAssortmentId(new AssortmentId(bookRepository.getOne(bookId),
                shopRepository.getOne(shopId)));
    }

    @Override
    public AssortmentDto getOne(Integer bookId, Integer shopId) {
        return transfer(assortmentRepository.getAssortmentByAssortmentId(new AssortmentId(bookRepository.getOne(bookId),
                shopRepository.getOne(shopId))));
    }

    private AssortmentDto transfer(Assortment assortment) {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        AssortmentDto assortmentDto = new AssortmentDto();
        assortmentDto.setBookId(assortment.getAssortmentId().getBook().getId());
        assortmentDto.setShopId(assortment.getAssortmentId().getShop().getId());
        assortmentDto.setQuantity(assortment.getQuantity());
        assortmentDto.setPrice(assortment.getPrice());
        assortmentDto.setCreationDate(dateFormat.format(assortment.getCreationDate()));
        assortmentDto.setClassificationStatus(assortment.getClassification().getName());
        assortmentDto.setClassificationId(assortment.getClassification().getId());
        return assortmentDto;
    }

    private Assortment transfer(AssortmentDto assortmentDto) throws ParseException {
        Assortment assortment = new Assortment();
        assortment.setAssortmentId(new AssortmentId(bookRepository.getOne(assortmentDto.getBookId()),
                shopRepository.getOne(assortmentDto.getShopId())));
        assortment.setQuantity(assortmentDto.getQuantity());
        assortment.setPrice(assortmentDto.getPrice());
        assortment.setCreationDate(new SimpleDateFormat("MM/dd/yyyy").parse(assortmentDto.getCreationDate()));
        assortment.setClassification(classificationRepository.getClassificationById(
                assortmentDto.getClassificationId()));
        return assortment;
    }
}
