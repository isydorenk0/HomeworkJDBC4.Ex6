package org.example;

import org.example.entity.Book;
import org.example.helpers.BookHelper;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setDate("2021");
        BookHelper bookHelper = new BookHelper();
        bookHelper.addBook(book);
        System.out.println(book);
        System.out.println(bookHelper.getAuthorById(1));
        for (Book bookTmp : bookHelper.getBookList()) {
            System.out.println(bookTmp);
        }

    }
}