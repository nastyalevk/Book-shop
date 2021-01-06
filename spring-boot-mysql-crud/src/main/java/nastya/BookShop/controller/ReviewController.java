package nastya.BookShop.controller;

import nastya.BookShop.dto.review.ReviewDto;
import nastya.BookShop.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity getUserReview(@PathVariable("id") Integer id) {
        List<ReviewDto> reviewDto = reviewService.getUserReview(id);
        if (reviewDto.isEmpty()) {
            return new ResponseEntity("This user has no reviews", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(reviewDto, HttpStatus.OK);
    }

    @GetMapping("/shop-review/{id}")
    public ResponseEntity getShopReview(@PathVariable("id") Integer id) {
        List<ReviewDto> reviewDto = reviewService.getShopReview(id);
        if (reviewDto.isEmpty()) {
            return new ResponseEntity("This user has no reviews", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(reviewDto, HttpStatus.OK);
    }

    @GetMapping("/reviews")
    public ResponseEntity findAll() {
        List<ReviewDto> reviewDto = reviewService.findAll();
        if (reviewDto.isEmpty()) {
            return new ResponseEntity("This user has no reviews", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(reviewDto, HttpStatus.OK);
    }

    @PostMapping("/add-review")
    public ResponseEntity createReview(@RequestBody ReviewDto reviewDto) {
        reviewService.saveReview(reviewDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
