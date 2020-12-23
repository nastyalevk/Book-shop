package nastya.bookShop.Service;


import nastya.bookShop.repository.OrderContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderContentService {
    private final OrderContentRepository orderContentRepository;

    @Autowired
    public OrderContentService(OrderContentRepository orderContentRepository) {
        this.orderContentRepository = orderContentRepository;
    }
}
