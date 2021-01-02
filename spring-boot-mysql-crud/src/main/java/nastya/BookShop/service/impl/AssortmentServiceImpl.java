package nastya.BookShop.service.impl;

import nastya.BookShop.model.Assortment;
import nastya.BookShop.repository.AssortmentRepository;
import nastya.BookShop.service.api.AssortmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssortmentServiceImpl implements AssortmentService {

    private final AssortmentRepository assortmentRepository;

    @Autowired
    public AssortmentServiceImpl(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
    }

    @Override
    public List<Assortment> getAssortmentByShop(Integer shopId){
        List<Assortment> assortments = assortmentRepository.findAll();
        List<Assortment> result = new ArrayList<Assortment>();
        for(Assortment i : assortments){
            if (i.getAssortmentId().getShop().getId().intValue() == shopId.intValue()){
                result.add(i);
            }
        }
        return result;
    }
}
