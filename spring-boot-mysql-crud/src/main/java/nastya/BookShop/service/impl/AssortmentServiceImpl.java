package nastya.BookShop.service.impl;

import nastya.BookShop.dto.Assortment.AssortmentDto;
import nastya.BookShop.model.Assortment;
import nastya.BookShop.repository.AssortmentRepository;
import nastya.BookShop.service.api.AssortmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssortmentServiceImpl implements AssortmentService {

    private static final Logger logger = LoggerFactory.getLogger(AssortmentServiceImpl.class);

    private final AssortmentRepository assortmentRepository;

    @Autowired
    public AssortmentServiceImpl(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
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
