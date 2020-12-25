package nastya.BookShop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Data
@Entity
@Table(name = "book")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer id;

    @OneToMany(mappedBy = "assortmentId.book")
    @JsonIgnore
    private Set<Assortment> assortmentSet;

    @OneToMany(mappedBy = "orderContentId.book")
    @JsonIgnore
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
