package nastya.BookShop.service.impl;

import nastya.BookShop.model.Assortment;
import nastya.BookShop.repository.AssortmentRepository;
import nastya.BookShop.service.api.AssortmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssortmentServiceImpl implements AssortmentService {

    private final AssortmentRepository assortmentRepository;

    @Autowired
    public AssortmentServiceImpl(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
    }

    @Override
    public List<Assortment> getAssortmentByShop(Integer id) {
        return assortmentRepository.findAllByAssortmentIdShopId(id);
    }
}
