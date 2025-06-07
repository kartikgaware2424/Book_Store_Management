package com.bookStore.bookStore.service;

import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookRepository myRepo;

    public void saveMyBooks(MyBookList book)
    {
        myRepo.save(book);
    }
    public List<MyBookList> getmyAllBooks()
    {
        return myRepo.findAll();
    }
}
