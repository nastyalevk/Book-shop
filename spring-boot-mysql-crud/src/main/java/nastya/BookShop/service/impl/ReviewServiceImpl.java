package nastya.BookShop.service.impl;

import nastya.BookShop.model.Review;
import nastya.BookShop.repository.ReviewRepository;
import nastya.BookShop.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getUserReview(Integer id){
        List<Review> reviews = reviewRepository.findAll();
        List<Review> result = new ArrayList<Review>();
        for(Review i: reviews){
            if(i.getUser().getId().intValue() == id){
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public List<Review> getShopReview(Integer id) {
        List<Review> reviews = reviewRepository.findAll();
        List<Review> result = new ArrayList<Review>();
        for(Review i: reviews){
            if(i.getShop().getId().intValue() == id){
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    @Override
    public void saveReview(Review review){
        reviewRepository.save(review);
    }
}
