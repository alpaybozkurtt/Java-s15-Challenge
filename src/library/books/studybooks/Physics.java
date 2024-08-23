package library.books.studybooks;

import library.books.StudyBook;
import library.books.enums.Lesson;

public class Physics extends StudyBook {
    public Physics(int bookId, String bookName, String author, double price, boolean status, String edition, String category, Lesson lesson) {
        super(bookId, bookName, author, price, status, edition, category, lesson);
    }

    @Override
    public void display() {
        System.out.println(getBookId() + getBookName() + getLesson() + getAuthor() + getPrice());
    }
}
