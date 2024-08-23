package library;

import library.books.*;
import library.books.enums.Frequency;
import library.books.enums.Genre;
import library.books.enums.Lesson;
import library.books.novels.Fantasy;
import library.books.novels.ScienceFiction;
import library.books.novels.Thriller;
import library.books.studybooks.Math;
import library.individiuals.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(); //Kütüphane Oluştur.


        // Kitaplar oluştur.
        Book book1 = new Fantasy(1, "lord of the Rings", "J.R.R. Tolkien", 60.0, true, "10th Edition", "GOAT", Genre.FANTASY);
        Book book2 = new ScienceFiction(2, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 45.0, true, "1st Edition", "Futuristic", Genre.SCIENCEFICTION);
        StudyBook book3 = new Math(3, "Principles of Mathematics", "Bertrand Russell", 30.0, true, "1rd Edition", "Science", Lesson.MATH);
        Book book4 = new Magazine(4, "Some Magazine", "Some Author", 20.0, true, "2rd Edition", "Science", Frequency.MONTHLY);
        Book book5 = new Thriller(5, "In the Woods", "Tana French", 40.0, true, "3rd Edition", "Special", Genre.THRILLER);

        // Bu kitapları Kütüphaneye ekle.
        library.addBookToLib(book1);
        library.addBookToLib(book2);
        library.addBookToLib(book3);
        library.addBookToLib(book4);
        library.addBookToLib(book5);

        //Kitaplar Kütüphaneye eklendikten sonra tüm kitapları listele.
        System.out.println("\n Tüm Kitaplar listeleniyor:");
        library.listBooksInLib();

        //Readerlar oluştur.
        Reader reader = new Reader("Ali Veli", 88);
        Reader reader2 = new Reader("Ayşe Fatma", 99);

        //Readerları Library'ye ekle.
        System.out.println("\nReader Ekleniyor.");
        library.addReaderToLib(reader);
        library.addReaderToLib(reader2);

        //book1'i (LOTR) Ödünç Al
        System.out.println("book1 Ödünç Alınıyor.");
        library.borrowBook(reader.getId(), book1);

        //Ödünç alınan book1 (LOTR)'un status değişikliğini Yazara göre listeleme yöntemiyle kontrol et.
        System.out.println("\nJ.R.R. Tolkien adlı yazarın kitapları listeleniyor:");
        System.out.println(library.listBooksByAuthor("J.R.R. Tolkien"));


        //book1 (LOTR) Library'ye return ediliyor.
        System.out.println("\nbook1 Return Ediliyor.");
        library.returnBook(reader.getId(), book1);

        // book4 remove ediliyor.
        System.out.println("\nbook4 (Some Magazine) remove ediliyor.");
        library.removeBookFromLib(book4.getBookId());

        // book4'ün remove u sonrası tüm kitaplar listeleniyor.
        System.out.println("\nTüm kitaplar listeleniyor.");
        library.listBooksInLib();


        //Librarian oluşturulup override methodu çalıştırılıyor.
        Person librarian = new Librarian("Jane Doe", "FeelFreeToPass");
        librarian.whoYouAre();
    }
}
