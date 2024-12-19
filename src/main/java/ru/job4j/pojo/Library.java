package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("Silk", 100);
        Book bookTwo = new Book("It", 170);
        Book bookThree = new Book("Clean code", 10);
        Book bookFour = new Book("Girl", 1000);
        Book[] books = new Book[]{bookOne, bookTwo, bookThree, bookFour};

        for (int i = 0; i < books.length; i++) {
            System.out.println("Book name: " + books[i].getName());
            System.out.println("Book pages: " + books[i].getPageNumbers());
        }
        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book name: " + books[i].getName());
            System.out.println("Book pages: " + books[i].getPageNumbers());
        }

        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println("Book name: " + books[i].getName());
                System.out.println("Book pages: " + books[i].getPageNumbers());
            }
        }
    }
}
