package library.books;

import library.books.enums.Frequency;

public class Magazine extends Book{
    private Frequency frequency;

    public Magazine(int bookId, String bookName, String author, double price, boolean status, String edition, String category, Frequency frequency) {
        super(bookId, bookName, author, price, status, edition, category);
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    @Override
    public void display() {

    }

    @Override
    public String toString() {
        return super.toString() + " {" +
                "frequency=" + frequency +
                "} ";
    }
}
