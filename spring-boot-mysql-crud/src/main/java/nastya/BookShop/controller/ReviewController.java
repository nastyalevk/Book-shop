package nastya.BookShop.controller;

import nastya.BookShop.dto.review.ReviewDto;
import nastya.BookShop.service.api.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserReview(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity(reviewService.getUserReview(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/shop/{id}")
    public ResponseEntity getShopReview(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity(reviewService.getShopReview(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity findAll() {
        try {
            return new ResponseEntity(reviewService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity createReview(@RequestBody ReviewDto reviewDto) {
        try {
            reviewService.saveReview(reviewDto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Review error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
