package nastya.BookShop.service;

import nastya.BookShop.model.Assortment;
import nastya.BookShop.repository.AssortmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssortmentService {

    private final AssortmentRepository assortmentRepository;

    @Autowired
    public AssortmentService(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
    }

    public Optional<Assortment> getAssortmentByShop(Integer shopId){
        return null;
    }
}
