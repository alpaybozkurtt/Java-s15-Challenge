package library.books;

import library.books.enums.Lesson;

public abstract class StudyBook extends Book {
    private Lesson lesson;

    public StudyBook(int bookId, String bookName, String author, double price, boolean status, String edition, String category, Lesson lesson) {
        super(bookId, bookName, author, price, status, edition, category);
        this.lesson = lesson;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return super.toString() + " {" +
                "lesson=" + lesson +
                "} ";
    }
}
