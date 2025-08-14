import java.util.*;

class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Issued: " + isIssued;
    }
}

public class LibrarySystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seed();
        menu();
    }

    static void seed() {
        books.add(new Book(1, "Java Basics"));
        books.add(new Book(2, "Python for Beginners"));
        books.add(new Book(3, "Data Structures"));
    }

    static void menu() {
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": viewBooks(); break;
                case "2": issueBook(); break;
                case "3": returnBook(); break;
                case "4": search(); break;
                case "5": System.out.println("Bye!"); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books.");
            return;
        }
        for (Book b : books) System.out.println(b);
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = readInt();
        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = readInt();
        for (Book b : books) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    static void search() {
        System.out.print("Enter keyword: ");
        String kw = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.title.toLowerCase().contains(kw)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No matches.");
    }

    static int readInt() {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}