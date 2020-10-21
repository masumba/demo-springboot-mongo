package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/add-book")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Added Book with id: "+book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    @GetMapping("/findBook/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return bookRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepo.deleteById(id);
        return "Boom deleted with id: "+id;
    }
}
