package nastya.BookShop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer id;

    @OneToMany(mappedBy = "assortmentId.book")
    private Set<Assortment> assortmentSet;

    @OneToMany(mappedBy = "orderContentId.book")
    private Set<OrderContent> orderContentSet;

    @Column(name = "book_name")
    private String bookName;
    private String author;
    private String genre;
    @Column(name = "publication_year")
    private Integer publicationYear;
    private Integer pages;
    private String description;

    public Book() {}
}
