package org.example.helpers;

import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class BookHelper {
    private SessionFactory sessionFactory;

    public BookHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    public Book getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        return session.get(Book.class, id);
    }

    public void addBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> getBookList(){
        Session session = sessionFactory.openSession();
        Query<Book> q = session.createQuery("from org.example.entity.Book", Book.class);
        List<Book> bookList =  q.list();
        session.close();
        return bookList;
    }

}
