package com.bookStore.bookStore.service;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BookRepository bRepo;

    public void save(Book b)
    {
        bRepo.save(b);

    }
    public List<Book> getAllBook()
    {
        return bRepo.findAll();
    }

    public Book getById(int id)
    {
        return bRepo.findById(id).get();
    }

}
