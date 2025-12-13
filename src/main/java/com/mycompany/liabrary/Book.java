package com.mycompany.liabrary;


public class Book {
    private String name;
    private final int id;
    private String authorName;
    private int totalNumberOfCopies;
    private int numberOfSoldCopies;
    private int numberOfRentedCopies;
    private double sellingPrice;
    private double rentingPrice;
    private static int counter = 0;

    public Book(String name, String authorName, int totalNumberOfCopies,
                double sellingPrice, double rentingPrice) {
        this.id = counter++;
        this.name = name;
        this.authorName = authorName;
        this.totalNumberOfCopies = totalNumberOfCopies;
        this.numberOfSoldCopies = 0;
        this.numberOfRentedCopies = 0;
        this.sellingPrice = sellingPrice;
        this.rentingPrice = rentingPrice;
    }

    // Getters
    public String getName() { return name; }
    public int getId() { return id; }
    public String getAuthorName() { return authorName; }
    public int getTotalNumberOfCopies() { return totalNumberOfCopies; }
    public int getNumberOfSoldCopies() { return numberOfSoldCopies; }
    public int getNumberOfRentedCopies() { return numberOfRentedCopies; }
    public double getSellingPrice() { return sellingPrice; }
    public double getRentingPrice() { return rentingPrice; }

    public int getAvailableCopies() {
        return totalNumberOfCopies - numberOfSoldCopies - numberOfRentedCopies;
    }

    public void addCopies(int copies) {
        if (copies > 0)
            totalNumberOfCopies += copies;
    }

    public void sellCopies(int copies) {
        if (copies > 0 && getAvailableCopies() >= copies) {
            numberOfSoldCopies += copies;
        }
    }

    public void rentCopy() {
        if (getAvailableCopies() > 0) {
            numberOfRentedCopies++;
        }
    }

    public void returnCopy() {
        if (numberOfRentedCopies > 0) {
            numberOfRentedCopies--;
        }
    }

    
    public void setName(String name) { this.name = name; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
    public void setSellingPrice(double sellingPrice) { this.sellingPrice = sellingPrice; }
    public void setRentingPrice(double rentingPrice) { this.rentingPrice = rentingPrice; }

    public static int getCounter() { return counter; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + authorName + '\'' +
                ", total=" + totalNumberOfCopies +
                ", sold=" + numberOfSoldCopies +
                ", rented=" + numberOfRentedCopies +
                ", available=" + getAvailableCopies() +
                ", sellPrice=" + sellingPrice +
                ", rentPrice=" + rentingPrice +
                '}';
    }
}