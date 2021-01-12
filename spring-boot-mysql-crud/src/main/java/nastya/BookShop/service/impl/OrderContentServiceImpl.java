package nastya.BookShop.service.impl;

import nastya.BookShop.dto.orderContent.OrderContentDto;
import nastya.BookShop.model.OrderContent;
import nastya.BookShop.model.OrderContentId;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.repository.OrderContentRepository;
import nastya.BookShop.repository.OrderRepository;
import nastya.BookShop.service.api.OrderContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderContentServiceImpl implements OrderContentService {

    private static final Logger logger = LoggerFactory.getLogger(OrderContentServiceImpl.class);

    private final OrderContentRepository orderContentRepository;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderContentServiceImpl(OrderContentRepository orderContentRepository, BookRepository bookRepository,
                                   OrderRepository orderRepository) {
        this.orderContentRepository = orderContentRepository;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderContentDto> findAll() {
        try {
            List<OrderContent> orderContents = orderContentRepository.findAll();
            List<OrderContentDto> orderContentDtos = new ArrayList<>();
            for (OrderContent i : orderContents) {
                orderContentDtos.add(transfer(i));
            }
            return orderContentDtos;
        } catch (Exception e) {
            logger.error("Order content error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderContentDto> getOrderContent(Integer id) {
        try {
            List<OrderContent> orderContents = orderContentRepository.findAllByOrderContentIdOrder(id);
            List<OrderContentDto> orderContentDtos = new ArrayList<>();
            for (OrderContent i : orderContents) {
                orderContentDtos.add(transfer(i));
            }
            return orderContentDtos;
        } catch (Exception e) {
            logger.error("Order content error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderContent saveOrderContent(OrderContentDto orderContentDto) {
        try {
            OrderContent orderContent = transfer(orderContentDto);
            orderContentRepository.save(orderContent);
            return orderContent;
        } catch (Exception e) {
            logger.error("Order content error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }


    private OrderContentDto transfer(OrderContent orderContent) {
        OrderContentDto orderContentDto = new OrderContentDto();
        orderContentDto.setOrderId(orderContent.getOrderContentId().getOrder().getId());
        orderContentDto.setBookId(orderContent.getOrderContentId().getBook().getId());
        orderContentDto.setQuantity(orderContent.getQuantity());
        orderContentDto.setPrice(orderContent.getPrice());
        return orderContentDto;
    }

    private OrderContent transfer(OrderContentDto orderContentDto) {
        OrderContent orderContent = new OrderContent();
        orderContent.setOrderContentId(new OrderContentId(orderRepository.getOne(orderContentDto.getOrderId()),
                bookRepository.getOne(orderContentDto.getBookId())));
        orderContent.setQuantity(orderContentDto.getQuantity());
        orderContent.setPrice(orderContentDto.getPrice());
        return orderContent;
    }
}
