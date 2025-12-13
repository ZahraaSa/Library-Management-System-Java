package com.mycompany.liabrary;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends Stakeholder {
    private final int id;
    private String address;
    private String status; 
    private static int counter = 0;
    private final ArrayList<RentedBook> rentedBooks;

    public Client(String address, String status, String firstName,String lastName, char gender, String phone) {
        super(firstName, lastName, gender, phone);
        this.id = counter++;
        this.address = address;
        this.status = status;
        this.rentedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public ArrayList<RentedBook> getRentedBooks() { return rentedBooks; }
// .
    public void addRentedBook(RentedBook rentedBook) {
        rentedBooks.add(rentedBook);
    }

    public boolean removeRentedBook(int bookId) {
        return rentedBooks.removeIf(rb -> rb.getBook().getId() == bookId);
    }
// if client does not return rentbook in time
    public boolean hasOverdueBooks(LocalDate currentDate) {
        for (RentedBook rb : rentedBooks) {
            if (rb.getRentedDate().plusDays(7).isBefore(currentDate)) {
                return true;
            }
        }
        return false;
    }
    

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", rentedCount=" + rentedBooks.size() +
                "} " + super.toString();
    }
    
    
    public boolean isEligibleForTransaction(LocalDate currentDate) {
        boolean isActive = "active".equalsIgnoreCase(this.status);
    boolean hasNoOverdue = !this.hasOverdueBooks(currentDate);
    return isActive && hasNoOverdue; 
}
    }
