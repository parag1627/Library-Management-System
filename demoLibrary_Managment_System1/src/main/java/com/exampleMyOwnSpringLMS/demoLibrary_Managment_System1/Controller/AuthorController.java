package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Controller;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.AuthorAddRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Author;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {


       @Autowired
       AuthorService authorService;

       @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorAddRequestDTO authorAddRequestDTO){
           authorService.addAuthor(authorAddRequestDTO);
           return "YES , AUTHOR IS ADDED NOW";
       }

//       public String addAuthor(@RequestBody Author author){
//
//           authorService.addAuthor(author);
//           return "Author added successfully";
//       }

    //      authorService.addAuthor(author);
//      return "Author added Succesfully";
//       }
    @GetMapping("/get_authors")
    public List<Author> getAuthors(){
       return  authorService.getAuthors();
    }
}
