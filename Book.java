package Library;

// Beskrivning av klassens ansvar:
// Lagrar information om en bok och hanterar bokens utlåningsstatus.

import java.util.*;

public class Book {

    private String title;
    private String author;
    private boolean borrowed;
    static ArrayList<Book> booksInLibrary = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // En konstruktor som tar emot bokens titel och författare. En ny bok ska vara tillgänglig när objektet skapas.
    public Book(String title, String author, boolean borrowed) {
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;
    }

    // - Metod för att kontrollera om boken är utlånad
    public boolean isBorrowed() {
        return borrowed;
    }

    // Metoden gör det möjligt för användaren att se information om böckerna: titel, författare, status
    public static void showLibrary() {
        System.out.println("\n--- BIBLIOTEKETS BÖCKER ---");
        for (int i = 0; i < booksInLibrary.size(); i++) {
            Book b = booksInLibrary.get(i);
            String status = b.borrowed ? "Utlånad" : "Tillgänglig";

            System.out.println((i + 1) + " " + b.title + " av " + b.author + " - " + status);
        }
    }

    // Metod som tillåter utlåning
    public static void borrowBook() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Ange bokens nummer: ");
            int bookNumber = Integer.parseInt(scan.nextLine());
            int index = bookNumber - 1;
            if (index < 0 || index >= booksInLibrary.size()) {
                System.out.println("Boken finns inte.");
            } else if (booksInLibrary.get(index).borrowed) {
                System.out.println("Boken är redan utlånad.");
            } else {
                Book b = booksInLibrary.get(index);
                b.borrowed = true;
                System.out.println("Du har lånat " + b.title + " av " + b.author);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ogiltigt val. Vänlig välj en bok i biblioteket.");
        } catch (InputMismatchException e) {
            System.out.println("Ogiltigt val. Vänlig välj en bok i biblioteket.");
        }
    }

    // Metod som gör det möjligt att lämna tillbaka en bok
    public static void returnBook() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Ange bokens nummer: ");
            int bookNumber = Integer.parseInt(scan.nextLine());
            int index = bookNumber - 1;
            if (index < 0 || index >= booksInLibrary.size()) {
                System.out.println("Boken finns inte.");
            } else if (booksInLibrary.get(index).isBorrowed()) {
                Book b = booksInLibrary.get(index);
                b.borrowed = false;
                System.out.println("Du har lämnat tillbaka " + b.title + " av " + b.author);
            } else {
                System.out.println("Du kan inte lämna tillbaka en bok som inte är utlånad!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ogiltigt val. Vänlig välj en bok i biblioteket.");
        } catch (InputMismatchException e) {
            System.out.println("Ogiltigt val. Vänlig välj en bok i biblioteket.");
        }
    }

    // Metod som gör det möjligt att söka efter en bok och kontrollera om den är utlånad
    public static void searchBook() {
        System.out.println("Vilken bok letar du efter? ");
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        String search = scan.nextLine().trim().toLowerCase();

        for (Book book : booksInLibrary) {
            if (book.getTitle().toLowerCase().contains(search)) {
                found = true;
                System.out.println("Boken hittades i biblioteket: " + book);
            } else if (book.getAuthor().toLowerCase().contains(search.toLowerCase())) {
                found = true;
                System.out.println("Boken hittades i bibliotetket: " + book);
            }
        }
        if (!found) {
            System.out.println("Boken finns inte.");
        }
    }

    @Override
    public String toString() {
        String status = this.borrowed ? "Utlånad" : "Tillgänglig";
        return getTitle() + " av " + getAuthor() + "\nBoken är " + status;
    }
}
