package nastya.BookShop.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Integer id;
    private String bookName;
    private String author;
    private String genre;
    private Integer publicationYear;
    private Integer pages;
    private String description;

    public BookDto(Integer id, String bookName, String author, String genre, Integer publicationYear, Integer pages, String description) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.description = description;
    }

    public BookDto() {
    }
}
