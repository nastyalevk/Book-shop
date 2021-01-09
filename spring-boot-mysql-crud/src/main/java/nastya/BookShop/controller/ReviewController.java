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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserReview(@PathVariable("id") Integer id) {
        List<ReviewDto> reviewDto = reviewService.getUserReview(id);
        if (reviewDto.isEmpty()) {
            return new ResponseEntity("This user has no reviews", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(reviewDto, HttpStatus.OK);
    }

    @GetMapping("/shop/{id}")
    public ResponseEntity getShopReview(@PathVariable("id") Integer id) {
        List<ReviewDto> reviewDto = reviewService.getShopReview(id);
        if (reviewDto.isEmpty()) {
            return new ResponseEntity("This user has no reviews", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(reviewDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity findAll() {
        List<ReviewDto> reviewDto = reviewService.findAll();
        if (reviewDto.isEmpty()) {
            return new ResponseEntity("This user has no reviews", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(reviewDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createReview(@RequestBody ReviewDto reviewDto) {
        reviewService.saveReview(reviewDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
