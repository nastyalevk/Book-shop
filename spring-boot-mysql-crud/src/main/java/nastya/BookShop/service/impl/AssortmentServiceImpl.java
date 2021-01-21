package nastya.BookShop.service.impl;

import nastya.BookShop.dto.Assortment.AssortmentDto;
import nastya.BookShop.model.Assortment;
import nastya.BookShop.model.Book;
import nastya.BookShop.repository.AssortmentRepository;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.service.api.AssortmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AssortmentServiceImpl implements AssortmentService {

    private static final Logger logger = LoggerFactory.getLogger(AssortmentServiceImpl.class);

    private final AssortmentRepository assortmentRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AssortmentServiceImpl(AssortmentRepository assortmentRepository, BookRepository bookRepository) {
        this.assortmentRepository = assortmentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<AssortmentDto> getAssortmentByShop(Integer id) {
        try {
            List<Assortment> assortments = assortmentRepository.findAllByAssortmentIdShopId(id);
            List<AssortmentDto> assortmentDtos = new ArrayList<>();
            for (Assortment i : assortments) {
                assortmentDtos.add(transfer(i));
            }
            return assortmentDtos;
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getPrice(Integer id) {
//        Book book = bookRepository.getOne(id);
        List<Assortment> assortments =
                assortmentRepository.findAssortmentByAssortmentId_Book(bookRepository.getOne(id));
        List<Integer> prices = new ArrayList<>();
        for (Assortment i : assortments) {
            prices.add(i.getPrice());
        }
        Collections.sort(prices);
        return prices.get(0);
    }

    private AssortmentDto transfer(Assortment assortment) {
        AssortmentDto assortmentDto = new AssortmentDto();
        assortmentDto.setBookId(assortment.getAssortmentId().getBook().getId());
        assortmentDto.setShopId(assortment.getAssortmentId().getShop().getId());
        assortmentDto.setQuantity(assortment.getQuantity());
        assortmentDto.setPrice(assortment.getPrice());
        assortmentDto.setCreationDate(assortment.getCreationDate());
        assortmentDto.setClassificationStatus(assortment.getClassification().getName());
        assortmentDto.setClassificationId(assortment.getClassification().getId());
        return assortmentDto;
    }
}
