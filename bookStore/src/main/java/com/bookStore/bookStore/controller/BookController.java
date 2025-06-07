package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.service.BooksService;
import com.bookStore.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private MyBookListService myBookService;
    @Autowired
    private BooksService service;

    @GetMapping("/")
    public  String home()
    {
        return "home";

    }
    @GetMapping("/add_book")
    public String add_book()
    {
        return "add_book";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b )
    {
        service.save(b);
      return "message";
    }
    @GetMapping("available_books")
    public ModelAndView getAllBook()
    {
      List<Book> list=service.getAllBook();
//      ModelAndView m=new ModelAndView();
//      m.setViewName("available_book");
//      m.addObject("book",list);
      return new ModelAndView("available_book","book",list);
    }
@GetMapping("/my_books")
    public String getMyBooks(Model model)
{
    List<MyBookList> list=myBookService.getmyAllBooks();
    model.addAttribute("book",list);
    return  "my_books";
}
@RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id)
{
    Book b=service.getById(id);
    MyBookList mb=new MyBookList(b.getId(),b.getTitle(),b.getAuthor(),b.getCategory(),b.getPrice());
    myBookService.saveMyBooks(mb);
    return "redirect:/my_books";
}


}
