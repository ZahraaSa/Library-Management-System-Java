package com.mycompany.liabrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Library {
    private  ArrayList<Book> books;
    private  ArrayList<Client> clients;
    private  ArrayList<Employee> employees;

    public Library() {
        books = new ArrayList<>();
        clients = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addClient(Client client) { clients.add(client); }
    public void addEmployee(Employee employee) { employees.add(employee); }

    public Client findClientById(int id) {
        for (Client c : clients) if (c.getId() == id) return c;
        return null;
    }

    public Book findBookById(int id) {
        for (Book b : books) if (b.getId() == id) return b;
        return null;
    }


    public boolean rentBook(int clientId, int bookId, LocalDate rentDate) {
    Client client = findClientById(clientId);
    Book book = findBookById(bookId);
    if (client == null || !client.isEligibleForTransaction(LibraryApp.currentDate)) return false; 
    if (book == null || book.getAvailableCopies() <= 0) return false;
    RentedBook rented = new RentedBook(book, rentDate);
    client.addRentedBook(rented);
    book.rentCopy();
    return true;
}

    public boolean returnBook(int clientId, int bookId) {
        Client client = findClientById(clientId);
        Book book = findBookById(bookId);

        if (client == null || book == null) return false;
        if (client.removeRentedBook(bookId)) {
            book.returnCopy();
            return true;
        }
        return false;
    }

    public boolean sellBook(int clientId, int bookId, int copies) {
    Client client = findClientById(clientId);
    Book book = findBookById(bookId);

    if (client == null || !client.isEligibleForTransaction(LibraryApp.currentDate)) return false;
    
    if (book == null || book.getAvailableCopies() < copies) return false;

    book.sellCopies(copies);
    return true;
}
//*zahraa
    public ArrayList<Book> getBooksSortedByPopularity() {
        ArrayList<Book> sorted = new ArrayList<>(books);
        sorted.sort(Comparator.comparingInt((Book b) ->b.getNumberOfSoldCopies() + b.getNumberOfRentedCopies()).reversed());
        return sorted;
    }

    public ArrayList<Client> getOverdueClients() {
        ArrayList<Client> overdue = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Client c : clients) {
            if (c.hasOverdueBooks(today)) {
                overdue.add(c);
            }
        }
        return overdue;
    }
    

    public ArrayList<Book> getBooks() { return books; }
    public ArrayList<Client> getClients() { return clients; }
    public ArrayList<Employee> getEmployees() { return employees; }
}