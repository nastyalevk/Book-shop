package nastya.BookShop.service.impl;

import nastya.BookShop.dto.review.ReviewDto;
import nastya.BookShop.model.Review;
import nastya.BookShop.repository.ReviewRepository;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.service.api.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ReviewRepository reviewRepository;
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ShopRepository shopRepository,
                             UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ReviewDto> getUserReview(Integer id) {
        try {
            List<Review> reviews = reviewRepository.findAllByUserId(id);
            List<ReviewDto> reviewDtos = new ArrayList<>();
            for (Review i : reviews) {
                reviewDtos.add(transfer(i));
            }
            return reviewDtos;
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ReviewDto> getShopReview(Integer id) {
        try {
            List<Review> reviews = reviewRepository.findAllByShopId(id);
            List<ReviewDto> reviewDtos = new ArrayList<>();
            for (Review i : reviews) {
                reviewDtos.add(transfer(i));
            }
            return reviewDtos;
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ReviewDto> findAll() {
        try {
            List<Review> reviews = reviewRepository.findAll();
            List<ReviewDto> reviewDtos = new ArrayList<>();
            for (Review i : reviews) {
                reviewDtos.add(transfer(i));
            }
            return reviewDtos;
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveReview(ReviewDto reviewDto) {
        try {
            reviewRepository.save(transfer(reviewDto));
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
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
