package library.books;

import library.books.enums.Genre;


public abstract class Novel extends Book {
    private Genre genre;

    public Novel(int bookId, String bookName, String author, double price, boolean status, String edition, String category, Genre genre) {
        super(bookId, bookName, author, price, status, edition, category);
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }


    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + " {" +
                "genre=" + genre +
                "} ";
    }
}
