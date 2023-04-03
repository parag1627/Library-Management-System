package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.BookAddRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.BookAddResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Author;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Book;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    public BookAddResponseDTO addBook(BookAddRequestDTO bookAddRequestDTO) throws Exception {


       Author author = authorRepository.findById(bookAddRequestDTO.getAuthorId()).orElse(new Author());

        Book book = new Book();
       book.setTitle(bookAddRequestDTO.getTitle());
       book.setGenere(bookAddRequestDTO.getGenere());
       book.setPrice(bookAddRequestDTO.getPrice());
       book.setIssued(false);
       book.setAuthor(author);

      author.getBooks().add(book);
      authorRepository.save(author);

      BookAddResponseDTO bookAddResponseDTO = new BookAddResponseDTO();
      bookAddResponseDTO.setTitle(book.getTitle());
      bookAddResponseDTO.setPrice(book.getPrice());

      return bookAddResponseDTO;
    }
}

