package library;

import library.books.Book;
import library.individiuals.Reader;
import java.util.*;

public class Library {
    private List<Book> books;
    private Map<Integer, Reader> readers;
    private Map<Integer, Set<Book>> borrowedBooksByReader;

    public Library() {
        this.readers = new HashMap<>();
        this.books = new ArrayList<>();
        this.borrowedBooksByReader = new HashMap<>();
    }

    public Map<Integer, Reader> getReaders() {
        return readers;
    }

    public void addReaderToLib(Reader reader) {
        if (!readers.containsKey(reader.getId())) {
            readers.put(reader.getId(), reader);
            System.out.println(reader.getFullName() + " with id: " + reader.getId() + " added as a reader successfully.");
        } else {
            System.out.println("Reader with ID " + reader.getId() + " already exists.");
        }
    }

    public void addBookToLib(Book book) {
        books.add(book);
    }

    public void removeBookFromLib(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
    }

    public void updateBook(int bookId, String newBookName, String newAuthor, double newPrice, boolean newStatus, String newEdition, String newCategory) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                book.setBookName(newBookName);
                book.setAuthor(newAuthor);
                book.setPrice(newPrice);
                book.setStatus(newStatus);
                book.setEdition(newEdition);
                book.setCategory(newCategory);
            }
        }
    }

    public void listBooksInLib() {
        if (books.isEmpty()) {
            System.out.println("There are no books in the library to list.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public List<Book> listBooksByCategory(String category) {
        List<Book> categorizedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                categorizedBooks.add(book);
            }
        }
        return categorizedBooks;
    }

    public List<Book> listBooksByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    public Book selectBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Book selectBookByName(String bookName) {
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void createBill(Reader reader, Book book) {
        System.out.println("Billing " + reader.getFullName() + " for borrowing the book: " + book.getBookName() + " 10 Dollars");
    }

    public void refundBill(Reader reader, Book book) {
        System.out.println("Refunding " + reader.getFullName() + " for returning the book: " + book.getBookName() + " 10 Dollars.");
    }

    public void borrowBook(int readerId, Book book) {
        Reader reader = readers.get(readerId);
        if (reader == null) {
            System.out.println("Reader not found.");
            return;
        }

        if (!book.isStatus()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        Set<Book> borrowedBooks = borrowedBooksByReader.getOrDefault(readerId, new HashSet<>());
        if (borrowedBooks.size() >= 5) {
            System.out.println("Reader cannot borrow more than 5 books.");
            return;
        }

        if (borrowedBooks.contains(book)) {
            System.out.println("Reader already has this book.");
            return;
        }

        //
        book.setStatus(false);
        borrowedBooks.add(book);
        borrowedBooksByReader.put(readerId, borrowedBooks);
        createBill(reader, book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(int readerId, Book book) {
        Set<Book> borrowedBooks = borrowedBooksByReader.get(readerId);
        if (borrowedBooks != null && borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStatus(true);
            refundBill(readers.get(readerId), book);
            if (borrowedBooks.isEmpty()) {
                borrowedBooksByReader.remove(readerId);
            }
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not borrowed by the reader.");
        }
    }
}