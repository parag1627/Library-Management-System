package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.AuthorAddRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.AuthorAddResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Author;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.Genere;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {


    @Autowired
    AuthorRepository authorRepository;

    public AuthorAddResponseDTO addAuthor(AuthorAddRequestDTO authorAddRequestDTO)
    {

        Author author = new Author();
//        Genere genere = new Genere();
        author.setAge(authorAddRequestDTO.getAge());
        author.setName(authorAddRequestDTO.getName());
        author.setEmail(authorAddRequestDTO.getEmail());
         authorRepository.save(author);

         AuthorAddResponseDTO authorAddResponseDTO = new AuthorAddResponseDTO();
         authorAddResponseDTO.setName(authorAddRequestDTO.getName());
         return authorAddResponseDTO;

     //  authorRepository.save(authorAddRequestDTO);
    }
    public List<Author> getAuthors(){
       return authorRepository.findAll();
    }
}
