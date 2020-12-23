package nastya.BookShop.service;

import nastya.BookShop.model.Order;
import nastya.BookShop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findByClientId(Integer clientId){
        return null;
    }

    public Order findById(Integer id){
        return orderRepository.getOne(id);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }
}
