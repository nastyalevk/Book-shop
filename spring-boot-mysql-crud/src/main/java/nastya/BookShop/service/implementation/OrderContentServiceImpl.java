package nastya.BookShop.service.implementation;

import nastya.BookShop.model.OrderContent;
import nastya.BookShop.repository.OrderContentRepository;
import nastya.BookShop.service.interf.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<OrderContent> getShopOrderContent(Integer shopId) {
        List<OrderContent> orderContents = orderContentRepository.findAll();
        List<OrderContent> result = new ArrayList<OrderContent>();
        for (OrderContent i: orderContents){
            if(i.getOrderContentId().getOrder().getShop().getId().intValue() == shopId){
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public List<OrderContent> getUserOrderContent(Integer userId) {
        List<OrderContent> orderContents = orderContentRepository.findAll();
        List<OrderContent> result = new ArrayList<OrderContent>();
        for (OrderContent i: orderContents){
            if(i.getOrderContentId().getOrder().getUser().getId().intValue() == userId){
                result.add(i);
            }
        }
        return result;
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
