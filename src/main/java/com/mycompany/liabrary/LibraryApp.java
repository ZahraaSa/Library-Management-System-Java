package com.mycompany.liabrary;

import java.time.LocalDate;

public class LibraryApp {
    public static Library library = new Library();
    public static LocalDate currentDate = LocalDate.now(); 

  
    static {
        Employee admin = new Employee("admin", "123", "Admin", "User", 'M', "0000000000");
        library.addEmployee(admin);
        
      addInitialClients();
        addInitialBooks();
        addInitialRentals();
    }
    private static void addInitialClients() {
   
        library.addClient(new Client("Damascus", "Active", "Ahmad", "Ali", 'M', "0912345678")); 
        library.addClient(new Client("Aleppo", "Active", "Sara", "Khalid", 'F', "0998765432")); 
        library.addClient(new Client("Homs", "Active", "Omar", "Hassan", 'M', "0934567890")); 
        library.addClient(new Client("Latakia", "Active", "Layla", "Fares", 'F', "0945678901")); 
        library.addClient(new Client("Hama", "Active", "Yousef", "Marwan", 'M', "0956789012")); 
        library.addClient(new Client("Tartus", "Active", "Noor", "Samir", 'F', "0967890123")); 
        library.addClient(new Client("Sweida", "Active", "Majd", "Wael", 'M', "0978901234")); 
        library.addClient(new Client("Daraa", "Active", "Reem", "Osama", 'F', "0989012345")); 
        library.addClient(new Client("Quneitra", "Active", "Bashar", "Adel", 'M', "0901234567")); 
        library.addClient(new Client("Deir ez-Zor", "Active", "Lina", "Ziad", 'F', "0923456789")); 
    }
    
    private static void addInitialBooks() {
    
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 5, 25.0, 5.0)); 
        library.addBook(new Book("1984", "George Orwell", 3, 20.0, 4.0)); 
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 7, 30.0, 6.0)); 
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", 4, 18.0, 3.5)); 
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 6, 22.0, 4.5)); 
        library.addBook(new Book("Moby Dick", "Herman Melville", 2, 35.0, 7.0)); 
        library.addBook(new Book("War and Peace", "Leo Tolstoy", 1, 50.0, 10.0)); 
        library.addBook(new Book("The Odyssey", "Homer", 8, 15.0, 3.0)); 
        library.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", 3, 28.0, 5.5)); 
        library.addBook(new Book("The Little Prince", "Antoine de Saint-Exupéry", 10, 12.0, 2.5)); 
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 5, 27.0, 5.0)); 
        library.addBook(new Book("Fahrenheit 451", "Ray Bradbury", 4, 19.0, 4.0)); 
        library.addBook(new Book("Jane Eyre", "Charlotte Brontë", 3, 21.0, 4.0)); 
        library.addBook(new Book("Wuthering Heights", "Emily Brontë", 2, 24.0, 4.5)); 
        library.addBook(new Book("One Hundred Years of Solitude", "Gabriel García Márquez", 4, 32.0, 6.5)); 
        library.addBook(new Book("Brave New World", "Aldous Huxley", 5, 23.0, 4.5)); 
        library.addBook(new Book("Don Quixote", "Miguel de Cervantes", 2, 38.0, 7.5)); 
        library.addBook(new Book("The Alchemist", "Paulo Coelho", 6, 17.0, 3.5)); 
        library.addBook(new Book("Les Misérables", "Victor Hugo", 1, 45.0, 9.0)); 
        library.addBook(new Book("The Picture of Dorian Gray", "Oscar Wilde", 3, 26.0, 5.0)); 
    }
    
    private static void addInitialRentals() {

    library.rentBook(0, 0, LocalDate.of(2025, 12, 3));   // Client 0, Book 0, rented 9 days ago (overdue)
    library.rentBook(1, 18, LocalDate.of(2025, 11, 29)); // Client 1, Book 18, rented 13 days ago (overdue)
    library.rentBook(7, 0, LocalDate.of(2025, 12, 11));  // Client 7, Book 0, rented 1 day ago (not overdue)
    library.rentBook(2, 3, LocalDate.of(2025, 12, 1));   // Client 2, Book 3, rented 11 days ago (overdue)
    library.rentBook(2, 4, LocalDate.of(2025, 12, 4));   // Client 2, Book 4, rented 8 days ago (overdue)
    library.rentBook(7, 12, LocalDate.of(2025, 12, 5));  // Client 7, Book 12, rented 7 days ago (not overdue, boundary)
    library.rentBook(4, 6, LocalDate.of(2025, 12, 4));   // Client 4, Book 6, rented 8 days ago (overdue)
    library.rentBook(7, 18, LocalDate.of(2025, 12, 11)); // Client 7, Book 18, rented 1 day ago (not overdue)
}
}