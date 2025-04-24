package com.example.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepository bookrepository ;
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookrepository.save(book);
	}
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookrepository.findAll();
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book not found with id " + id));
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
		 return bookrepository.findById(id)
		            .map(book -> {
		                book.setTitle(updatedBook.getTitle());
		                book.setAuthor(updatedBook.getAuthor());
		                book.setGenre(updatedBook.getGenre());
		                book.setYearPublished(updatedBook.getYearPublished());
		                return bookrepository.save(book);
		            })
		            .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Long id) {
	    bookrepository.deleteById(id);
	    return "Book with id " + id + " has been deleted";
	}

}
