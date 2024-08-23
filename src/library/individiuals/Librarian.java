package library.individiuals;

import library.Library;

public class Librarian extends Person {
    private String password;

    public Librarian(String fullName, String password) {
        super(fullName);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void membershipCheck(int readerId, Library library) {
        if (library.getReaders().containsKey(readerId)) {
            System.out.println("ReaderId " + readerId + " verified. Applicant is a valid member of the library.");
        } else {
            System.out.println("There is no ReaderId " + readerId + "registered in the library.");
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Librarian named " + getFullName());
    }
}