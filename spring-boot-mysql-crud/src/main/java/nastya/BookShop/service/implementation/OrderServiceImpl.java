package nastya.BookShop.service.implementation;

import nastya.BookShop.model.Order;
import nastya.BookShop.repository.OrderRepository;
import nastya.BookShop.service.interf.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findByClientId(Integer clientId){
        return null;
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
