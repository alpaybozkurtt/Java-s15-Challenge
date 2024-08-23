package library.individiuals;

import library.books.Book;
import library.individiuals.Person;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {
    private int id;
    private Set<Book> borrowedBooks;

    public Reader(String fullName) {
        super(fullName);
        this.borrowedBooks = new HashSet<>();
    }

    public Reader(String fullName, int id) {
        super(fullName);
        this.id = id;
        this.borrowedBooks = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Reader named " + getFullName());
    }
}