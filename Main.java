package Library;

// Beskrivning av klassens ansvar:
// Visar menyn, läser användarens inmatning, innehåller listan med
// böcker och anropar objektens metoder.

import java.util.*;

import static Library.Book.*;

public class Main {

    public static void main(String[] args) {

        // nya bok-objekt skapas och läggs till i en ArrayList
        booksInLibrary.add(new Book("Java från grunden", "Anna Andersson", false));
        booksInLibrary.add(new Book("Clean Code", "Robert C. Martin", false));
        booksInLibrary.add(new Book("Databasteknik", "Björn Berg", false));

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("--- BIBLIOTEK ---");
            System.out.println("1. Visa böcker");
            System.out.println("2. Låna en bok");
            System.out.println("3. Lämna tillbaka en bok");
            System.out.println("4. Söka efter en bok");
            System.out.println("5. Avsluta");
            System.out.print("Välj: ");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                showLibrary();
            } else if (choice.equals("2")) {
                borrowBook();
            } else if (choice.equals("3")) {
                returnBook();
            } else if (choice.equals("4")) {
                searchBook();
            } else if (choice.equals("5")) {
                running = false;
                System.out.println("Programmet avslutas.");
            } else {
                System.out.println("Ogiltigt menyval.");
            }
        }
        scanner.close();
    }

}
