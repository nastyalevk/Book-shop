package nastya.BookShop.controller;

import nastya.BookShop.model.Review;
import nastya.BookShop.service.interf.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/user-review/{id}")
    public List<Review> getUserReview(@PathVariable("id") Integer id){
        return reviewService.getUserReview(id);
    }

    @GetMapping("/shop-review/{id}")
    public List<Review> getShopReview(@PathVariable("id") Integer id){
        return reviewService.getShopReview(id);
    }

}
