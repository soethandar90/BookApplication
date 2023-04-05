package BookApplication.services;

import BookApplication.domains.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book addBook(Book book);

    Book updateBook(String isbn, Book book);

    void deleteBook(String isbn);

    Optional<Book> getBook(String isbn);

    List<Book> getAllBook();
}
