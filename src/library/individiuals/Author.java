package library.individiuals;

import library.books.Book;
import library.individiuals.Person;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person {
    private Set<Book> authorsBooks;

    public Author(String fullName) {
        super(fullName);
        this.authorsBooks = new HashSet<>();
    }

    public Set<Book> getAuthorsBooks() {
        return authorsBooks;
    }

    public void addBookToAuthor(Book book) {
        authorsBooks.add(book);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an Author named " + getFullName());
    }
}