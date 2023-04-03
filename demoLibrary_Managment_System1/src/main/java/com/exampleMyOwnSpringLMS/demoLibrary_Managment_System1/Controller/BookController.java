package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Controller;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.BookAddRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.BookAddResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Author;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Book;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository.AuthorRepository;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

     @PostMapping("/add")
    public BookAddResponseDTO addBook(@RequestBody BookAddRequestDTO bookAddRequestDTO) throws Exception {
       return  bookService.addBook(bookAddRequestDTO);
//       return "YES BOOK IS ADDED ";

    }

}