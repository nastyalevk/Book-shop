package nastya.BookShop.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssortmentId implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    public AssortmentId() {
    }

    public AssortmentId(Book book, Shop shop) {
        this.book = book;
        this.shop = shop;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssortmentId that = (AssortmentId) o;
        return Objects.equals(book, that.book) && Objects.equals(shop, that.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, shop);
    }
}
