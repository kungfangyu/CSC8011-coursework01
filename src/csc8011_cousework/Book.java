package csc8011_cousework;

//Create a Book class and define the variables
public class Book {
    private String bookId;
    private String bookTitle;
    private int yearPublished;
    private double price ;

    public Book(String bookId, String bookTitle, int yearPublished, double price) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getPrice() {
        return price;
    }

    // Transform csv data to show string
    public String toString() {
        return "BookId: "+ bookId +", BookTitle:" + bookTitle + ",Year Published:" + yearPublished + ",Price: £"
                + price;
    }

};
