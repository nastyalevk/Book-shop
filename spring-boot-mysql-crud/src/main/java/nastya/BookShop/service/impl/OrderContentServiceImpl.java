package nastya.BookShop.service.impl;

import nastya.BookShop.model.OrderContent;
import nastya.BookShop.repository.OrderContentRepository;
import nastya.BookShop.service.api.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderContentServiceImpl implements OrderContentService {
    private final OrderContentRepository orderContentRepository;

    @Autowired
    public OrderContentServiceImpl(OrderContentRepository orderContentRepository) {
        this.orderContentRepository = orderContentRepository;
    }

    @Override
    public List<OrderContent> findAll() {
        return orderContentRepository.findAll();
    }

    @Override
    public List<OrderContent> getShopOrderContent(Integer id) {
        return orderContentRepository.findAllByOrderContentIdOrderShopId(id);
    }

    @Override
    public List<OrderContent> getUserOrderContent(Integer id) {
        return orderContentRepository.findAllByOrderContentIdOrderUserId(id);
    }

    @Override
    public void saveOrderContent(OrderContent orderContent) {
        orderContentRepository.save(orderContent);
    }

    @Override
    public OrderContent getOne(Integer id) {
        return orderContentRepository.getOne(id);
    }

}
