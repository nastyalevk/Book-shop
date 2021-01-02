package nastya.BookShop.service.impl;

import nastya.BookShop.model.Order;
import nastya.BookShop.repository.OrderRepository;
import nastya.BookShop.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findByClientId(Integer clientId){
       List<Order> orders = orderRepository.findAll();
       List <Order> result = new ArrayList<Order>();
       for(Order i : orders){
           if (i.getUser().getId().intValue() == clientId){
                   result.add(i);
           }
       }
       return result;
    }

    @Override
    public Order findById(Integer id){
        return orderRepository.getOne(id);
    }

    @Override
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order){
        orderRepository.save(order);
    }
}
