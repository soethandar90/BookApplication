package BookApplication.controllers;

import BookApplication.domains.Book;
import BookApplication.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookservice;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookservice.addBook(book);
    }

    @PutMapping("/{isbn}")
    public Book updateBook(@PathVariable String isbn, @RequestBody Book book) {
        return bookservice.updateBook(isbn, book);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        bookservice.deleteBook(isbn);
    }

    @GetMapping("/{isbn}")
    public Optional<Book> getBook(@PathVariable String isbn) {
        return bookservice.getBook(isbn);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookservice.getAllBook();
    }
}
