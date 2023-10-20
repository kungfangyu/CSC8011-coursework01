package csc8011_cousework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class BookStoreWindowIO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean start = false;

        ArrayList<Book> BookList = new ArrayList<>();

        while (!start) {
            printMenu();
            try {
                int Options = scanner.nextInt();
                switch (Options) {
                    case 1:
                        System.out.println(BookStoreWindow.getStoreName());
                        break;
                    case 2:
                        fileRead(BookList);
                        break;
                    case 3:
                        showStoreInformation(BookList);
                        break;
                    case 4:
                        getBookStatistics(BookList);
                        break;
                    case 5:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Oops! It's Invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Oops! It's wrong option. Please try again");
                scanner.nextLine();
            }
        }
    }

    public static void printMenu() {
        System.out.println("-------------------------------");
        System.out.println("Option1: Show the store name.");
        System.out.println("Option2: Read csv file.");
        System.out.println("Option3: Show the book store information.");
        System.out.println("Option4: Show statistics on the books");
        System.out.println("Please enter your option: ");

    }

    public static void fileRead(ArrayList<Book> BookList) {
        try {
            File inputFile = new File("book.csv");
            Scanner line = new Scanner(inputFile);
            while (line.hasNext()) {
                String[] data = line.nextLine().split(",");

                /* Change data type from csv*/
                String bookId = data[0];
                String bookTitle = data[1];
                int yearPublished = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);
                Book Book = new Book(bookId, bookTitle, yearPublished, price);
                BookList.add(Book);
            }
            System.out.println(BookList);
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Something wrong");
        }
    }

    public static void showStoreInformation(ArrayList<Book> BookList) {
        System.out.println("Book shop name::" + BookStoreWindow.getStoreName());
        for (int i = 0; i < BookList.size(); i++) {
            System.out.println(BookList.get(i));
        }
    }

    public static void getBookStatistics(ArrayList<Book> BookList) {
        System.out.println("The statistics on highest value, oldest book, and average value of the books:");
        double MostExpensiveBook = BookStoreWindow.getMostExpensiveBook(BookList);
        System.out.println("Highest value book: Dune (published 1965), £" + MostExpensiveBook);
        int OldestBook = BookStoreWindow.getOldestBook(BookList);
        System.out.println("Oldest book: Jane Eyre (published " + OldestBook + ")");
        double AverageValue = BookStoreWindow.getAveragePrice(BookList);
        System.out.println("Average value of books: £" + String.format("%.2f", AverageValue));
    }


}
