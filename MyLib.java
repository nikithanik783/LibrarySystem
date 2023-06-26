import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    private List<Book> availableBooks;

    public Library() {
        availableBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
        System.out.println();
    }

    public void issueBook(int bookId) {
        for (Book book : availableBooks) {
            if (book.getId() == bookId) {
                availableBooks.remove(book);
                System.out.println("Book with ID " + bookId + " has been issued.");
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " is not available.");
    }

    public void returnBook(Book book) {
        availableBooks.add(book);
        System.out.println("Book with ID " + book.getId() + " has been returned.");
    }
}

public class MyLib {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books to the library
        library.addBook(new Book(1, "Book1", "Author1"));
        library.addBook(new Book(2, "Book2", "Author2"));
        library.addBook(new Book(3, "Book3", "Author3"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Book Issue and Return System");
            System.out.println("1. Display available books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter the ID of the book to issue: ");
                    int bookId = scanner.nextInt();
                    library.issueBook(bookId);
                    break;
                case 3:
                    System.out.print("Enter the ID of the book to return: ");
                    int returnBookId = scanner.nextInt();
                    Book returnBook = new Book(returnBookId, "", "");
                    library.returnBook(returnBook);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
