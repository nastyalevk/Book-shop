package nastya.bookShop.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "review_rate")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String comment;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    public Review(){}
}
