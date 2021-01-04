package nastya.BookShop.service.impl;

import nastya.BookShop.dto.order.OrderDto;
import nastya.BookShop.model.Classification;
import nastya.BookShop.model.Order;
import nastya.BookShop.repository.ClassificationRepository;
import nastya.BookShop.repository.OrderRepository;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShopRepository shopRepository;
    private final ClassificationRepository classificationRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ShopRepository shopRepository, ClassificationRepository classificationRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.shopRepository = shopRepository;
        this.classificationRepository = classificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<OrderDto> findByClientId(Integer id) {
        List<Order> orders = orderRepository.findAllByUserId(id);
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order i: orders){
            orderDtos.add(transfer(i));
        }
        return orderDtos;
    }

    @Override
    public OrderDto findById(Integer id) {
        return transfer(orderRepository.getOne(id));
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order i: orders){
            orderDtos.add(transfer(i));
        }
        return orderDtos;
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        orderRepository.save(transfer(orderDto));
    }

    private OrderDto transfer(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrderNumber(order.getOrderNumber());
        orderDto.setShopId(order.getShop().getId());
        orderDto.setDeliveryAddress(order.getDeliveryAddress());
        orderDto.setDescription(order.getDescription());
        orderDto.setOrderSubmitDate(order.getOrderSubmitDate());
        orderDto.setClassificationStatus(order.getClassification().getName());
        orderDto.setClassificationId(order.getClassification().getId());
        orderDto.setCost(order.getCost());
        orderDto.setOrderCompleteDate(order.getOrderCompleteDate());
        orderDto.setUserId(order.getUser().getId());
        return orderDto;
    }

    private Order transfer(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderNumber(orderDto.getOrderNumber());
        order.setShop(shopRepository.getShopById(orderDto.getShopId()));
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        order.setDescription(orderDto.getDescription());
        order.setOrderSubmitDate(orderDto.getOrderSubmitDate());
        order.setClassification(classificationRepository.getClassificationById(orderDto.getClassificationId()));
        order.setCost(orderDto.getCost());
        order.setOrderCompleteDate(orderDto.getOrderCompleteDate());
        order.setUser(userRepository.getOne(orderDto.getUserId()));
        return order;
    }
}
