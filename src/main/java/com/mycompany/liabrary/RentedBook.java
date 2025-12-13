package com.mycompany.liabrary;

import java.time.LocalDate;

public class RentedBook {
    private final Book book;
    private LocalDate rentedDate;

    public RentedBook(Book book, LocalDate rentedDate) {
        this.book = book;
        this.rentedDate = rentedDate;
    }

    public Book getBook() { return book; }
    public LocalDate getRentedDate() { return rentedDate; }

    public void setRentedDate(LocalDate rentedDate) { this.rentedDate = rentedDate; }

    @Override
    public String toString() {
        return "RentedBook{" +
                "bookId=" + book.getId() +
                ", bookName='" + book.getName() + '\'' +
                ", rentedDate=" + rentedDate +
                '}';
    }
}