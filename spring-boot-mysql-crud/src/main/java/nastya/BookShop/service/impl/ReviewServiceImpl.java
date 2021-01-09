package nastya.BookShop.service.impl;

import nastya.BookShop.dto.review.ReviewDto;
import nastya.BookShop.model.Review;
import nastya.BookShop.repository.ReviewRepository;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ShopRepository shopRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ReviewDto> getUserReview(Integer id) {
        List<Review> reviews = reviewRepository.findAllByUserId(id);
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review i : reviews) {
            reviewDtos.add(transfer(i));
        }
        return reviewDtos;
    }

    @Override
    public List<ReviewDto> getShopReview(Integer id) {
        List<Review> reviews = reviewRepository.findAllByShopId(id);
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review i : reviews) {
            reviewDtos.add(transfer(i));
        }
        return reviewDtos;
    }

    @Override
    public List<ReviewDto> findAll() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review i : reviews) {
            reviewDtos.add(transfer(i));
        }
        return reviewDtos;
    }

    @Override
    public void saveReview(ReviewDto reviewDto) {
        reviewRepository.save(transfer(reviewDto));
    }

    private ReviewDto transfer(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setUserId(review.getUser().getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        reviewDto.setShopId(review.getShop().getId());
        return reviewDto;
    }

    private Review transfer(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setUser(userRepository.getOne(reviewDto.getUserId()));
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setShop(shopRepository.getShopById(reviewDto.getShopId()));
        return review;
    }
}
