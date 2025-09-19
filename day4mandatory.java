item.java

// Base class representing a general item in the library
public class Item {
    // Common attributes for all library items
    protected String title;
    protected String author;
    protected int publicationYear;

    // Constructor for initializing Item
    public Item(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Method to get item details - will be overridden by subclasses
    public String getDetails() {
        return "Title: " + title + "\nAuthor: " + author + "\nYear: " + publicationYear;
    }
}

// File: Book.java
// Book class that extends Item
public class Book extends Item {
    private String ISBN;
    private String genre;

    // Constructor for Book
    public Book(String title, String author, int publicationYear, String ISBN, String genre) {
        super(title, author, publicationYear); // Call parent constructor
        this.ISBN = ISBN;
        this.genre = genre;
    }

    // Method Overriding - specialized version of getDetails
    @Override
    public String getDetails() {
        return super.getDetails() +
               "\nISBN: " + ISBN +
               "\nGenre: " + genre;
    }

    // Method Overloading - two versions of borrowItem
    public void borrowItem() {
        System.out.println(title + " has been borrowed.");
    }

    public void borrowItem(String borrowerName) {
        System.out.println(title + " has been borrowed by " + borrowerName + ".");
    }
}

// File: Magazine.java
// Magazine class that extends Item
public class Magazine extends Item {
    private int issueNumber;
    private String monthPublished;

    // Constructor
    public Magazine(String title, String author, int publicationYear, int issueNumber, String monthPublished) {
        super(title, author, publicationYear);
        this.issueNumber = issueNumber;
        this.monthPublished = monthPublished;
    }

    // Method Overriding
    @Override
    public String getDetails() {
        return super.getDetails() +
               "\nIssue Number: " + issueNumber +
               "\nMonth Published: " + monthPublished;
    }
}

// ile: DVD.java
// DVD class that extends Item
public class DVD extends Item {
    private int duration; // in minutes
    private String rating;

    // Constructor
    public DVD(String title, String author, int publicationYear, int duration, String rating) {
        super(title, author, publicationYear);
        this.duration = duration;
        this.rating = rating;
    }

    // Method Overriding
    @Override
    public String getDetails() {
        return super.getDetails() +
               "\nDuration: " + duration + " minutes" +
               "\nRating: " + rating;
    }
}

// File: Library.java
import java.util.ArrayList;

// Library class that manages Item objects (Polymorphism used here)
public class Library {
    // List to store items
    private ArrayList<Item> items;

    // Constructor
    public Library() {
        items = new ArrayList<>();
    }

    // Add an item to the library
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.title + " added to the library.");
    }

    // Remove an item by title
    public void removeItem(String title) {
        boolean found = false;
        for (Item item : items) {
            if (item.title.equalsIgnoreCase(title)) {
                items.remove(item);
                System.out.println(title + " removed from the library.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item with title '" + title + "' not found.");
        }
    }

    // Display all items using polymorphism
    public void displayItems() {
        System.out.println("\n--- Library Collection ---");
        for (Item item : items) {
            System.out.println(item.getDetails()); // Polymorphic call
            System.out.println("----------------------------");
        }
    }
}

// File: Main.java
// Main class to test the library system
public class Main {
    public static void main(String[] args) {
        // Create Library instance
        Library library = new Library();

        // Create some items
        Book book1 = new Book("Java Basics", "John Doe", 2020, "1234567890", "Programming");
        Magazine mag1 = new Magazine("Tech Monthly", "Jane Smith", 2021, 45, "September");
        DVD dvd1 = new DVD("Learning Java", "Tom Teacher", 2019, 120, "G");

        // Add items to the library
        library.addItem(book1);
        library.addItem(mag1);
        library.addItem(dvd1);

        // Display items in the library
        library.displayItems();

        // Borrow book (method overloading demo)
        book1.borrowItem();
        book1.borrowItem("Alice");

        // Remove an item
        library.removeItem("Tech Monthly");

        // Display items again
        library.displayItems();
    }
}