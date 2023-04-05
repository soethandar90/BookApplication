package BookApplication.services;

import BookApplication.domains.Book;
import BookApplication.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookrepository;

    @Override
    public Book addBook(Book book) {
        return bookrepository.save(book);
    }

    @Override
    public Book updateBook(String isbn, Book book) {
        Optional<Book> optionalBook = bookrepository.findById(isbn);
        if (!optionalBook.isPresent()) {
            System.err.println("Book not found with isbn " + isbn);
            return null;
        }

        Book existingBook = optionalBook.get();

        if (book.getAuthor() != null || book.getAuthor() == "" || book.getAuthor()!=existingBook.getAuthor()) {
            existingBook.setAuthor(book.getAuthor());
        }
        if (book.getTitle() != null || book.getTitle() == "" || book.getAuthor()!=existingBook.getTitle()) {
            existingBook.setTitle(book.getTitle());
        }
        if (book.getPrice() > 0 && book.getPrice() != existingBook.getPrice()) {
            existingBook.setPrice(book.getPrice());
        }
        return bookrepository.save(existingBook);
    }

    @Override
    public void deleteBook(String isbn) {
        bookrepository.deleteById(isbn);
    }

    @Override
    public Optional<Book> getBook(String isbn) {
        return bookrepository.findById(isbn);
    }

    @Override
    public List<Book> getAllBook() {
        return bookrepository.findAll();
    }
}
