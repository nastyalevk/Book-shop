package nastya.BookShop.service.implementation;

import nastya.BookShop.repository.OrderContentRepository;
import nastya.BookShop.service.interf.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderContentServiceImpl implements OrderContentService {
    private final OrderContentRepository orderContentRepository;

    @Autowired
    public OrderContentServiceImpl(OrderContentRepository orderContentRepository) {
        this.orderContentRepository = orderContentRepository;
    }
}
