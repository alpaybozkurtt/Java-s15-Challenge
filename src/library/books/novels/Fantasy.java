package library.books.novels;

import library.books.Novel;
import library.books.enums.Genre;

public class Fantasy extends Novel {

    public Fantasy(int bookId, String bookName, String author, double price, boolean status, String edition, String category, Genre genre) {
        super(bookId, bookName, author, price, status, edition, category, genre);
    }

    @Override
    public void display() {
        System.out.println(getBookId() + getBookName() + getGenre() + getAuthor() + getPrice());
    }

}
