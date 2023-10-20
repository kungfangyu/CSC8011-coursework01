package csc8011_cousework;

import java.util.ArrayList;
import java.text.DecimalFormat;


public class BookStoreWindow {
    private static String storeName = "Byte's Books";

    public static String getStoreName() {
        return storeName;
    }
    public static double getMostExpensiveBook(ArrayList<Book> BookList) {
        double MostExpensiveBook = 0;
        for(int i = 0; i < BookList.size(); i++) {
            Book bookPrice = BookList.get(i);
            double currentPrice = bookPrice.getPrice();
            if(currentPrice > MostExpensiveBook) {
                MostExpensiveBook =  currentPrice;
            }
        }
        return MostExpensiveBook;
    }

    public static int getOldestBook(ArrayList<Book> BookList) {
        int OldestBook = 2024; // Initialize fake year
        for (int i = 0; i < BookList.size(); i++) {
            Book yearPublished = BookList.get(i);
            int currentYear = yearPublished.getYearPublished();
            if (currentYear < OldestBook) {
                OldestBook = currentYear;
            }
        }
        return OldestBook;
    }

    public static double getAveragePrice(ArrayList<Book> BookList) {
        double TotalPrice = 0;
        for(int i = 0; i < BookList.size(); i++) {
            Book price = BookList.get(i);
            double Price = price.getPrice();
            TotalPrice += Price;
        }
        /* numbers of book */
        int BookNumber = BookList.size();
        /* make value to 2 decimal places */
        double AveragePrice = TotalPrice / BookNumber;
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(AveragePrice));
    }

}

