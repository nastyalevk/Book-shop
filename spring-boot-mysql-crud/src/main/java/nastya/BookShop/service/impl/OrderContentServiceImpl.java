package nastya.BookShop.service.impl;

import nastya.BookShop.dto.orderContent.OrderContentDto;
import nastya.BookShop.model.OrderContent;
import nastya.BookShop.model.OrderContentId;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.repository.OrderContentRepository;
import nastya.BookShop.repository.OrderRepository;
import nastya.BookShop.service.api.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderContentServiceImpl implements OrderContentService {

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
        List<OrderContent> orderContents = orderContentRepository.findAll();
        List<OrderContentDto> orderContentDtos = new ArrayList<>();
        for (OrderContent i : orderContents) {
            orderContentDtos.add(transfer(i));
        }
        return orderContentDtos;
    }

    @Override
    public List<OrderContentDto> getOrderContent(Integer id) {
        List<OrderContent> orderContents = orderContentRepository.findAllByOrderContentIdOrder(id);
        List<OrderContentDto> orderContentDtos = new ArrayList<>();
        for (OrderContent i : orderContents) {
            orderContentDtos.add(transfer(i));
        }
        return orderContentDtos;
    }

    @Override
    public OrderContent saveOrderContent(OrderContentDto orderContentDto) {
        OrderContent orderContent = transfer(orderContentDto);
        orderContentRepository.save(orderContent);
        return orderContent;
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
