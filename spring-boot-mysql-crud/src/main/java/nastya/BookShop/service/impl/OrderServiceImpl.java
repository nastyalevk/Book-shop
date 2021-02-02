package nastya.BookShop.service.impl;

import nastya.BookShop.dto.order.OrderDto;
import nastya.BookShop.model.Order;
import nastya.BookShop.repository.ClassificationRepository;
import nastya.BookShop.repository.OrderRepository;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Transactional
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
        return transfer(orderRepository.findAllByUserId(id));
    }

    @Override
    public List<OrderDto> findByClientUsername(String username) {
        return transfer(orderRepository.findByUserUsername(username));
    }

    @Override
    public OrderDto findById(Integer id) {
        return transfer(orderRepository.getOne(id));
    }

    @Override
    public List<OrderDto> findAll() {
        return transfer(orderRepository.findAll());
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        try {
            return transfer(orderRepository.save(transfer(orderDto)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderDto> getOrderByShop(Integer shopId) {
        return transfer(orderRepository.findByShopId(shopId));
    }

    private List<OrderDto> transfer(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order i : orders) {
            orderDtos.add(transfer(i));
        }
        return orderDtos;
    }

    private OrderDto transfer(Order order) {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getId());
        orderDto.setOrderNumber(order.getOrderNumber());
        orderDto.setShopId(order.getShop().getId());
        orderDto.setDeliveryAddress(order.getDeliveryAddress());
        orderDto.setDescription(order.getDescription());
        orderDto.setOrderSubmitDate(dateFormat.format(order.getOrderSubmitDate()));
        orderDto.setClassificationStatus(order.getClassification().getName());
        orderDto.setClassificationId(order.getClassification().getId());
        orderDto.setCost(order.getCost());
        orderDto.setOrderCompleteDate(dateFormat.format(order.getOrderCompleteDate()));
        orderDto.setUsername(order.getUser().getUsername());
        return orderDto;
    }

    private Order transfer(OrderDto orderDto) throws ParseException {
        Order order = new Order();
//        order.setId(orderDto.getId());
        order.setOrderNumber(orderDto.getOrderNumber());
        order.setShop(shopRepository.getShopById(orderDto.getShopId()));
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        order.setDescription(orderDto.getDescription());
        order.setOrderSubmitDate(new SimpleDateFormat("MM/dd/yyyy").parse(orderDto.getOrderSubmitDate()));
        order.setClassification(classificationRepository.getClassificationById(orderDto.getClassificationId()));
        order.setCost(orderDto.getCost());
        order.setOrderCompleteDate(new SimpleDateFormat("MM/dd/yyyy").parse(orderDto.getOrderCompleteDate()));
        order.setUser(userRepository.findByUsername(orderDto.getUsername()));
        return order;
    }
}
