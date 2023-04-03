package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Controller;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.IssueBookRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.IssueBookResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.TransactionResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public ResponseEntity  issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO) throws Exception {
        IssueBookResponseDTO issueBookResponseDTO;
        try{
           issueBookResponseDTO= transactionService.issueBook(issueBookRequestDTO);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity(issueBookResponseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("get")
    public List<TransactionResponseDTO> getAllTxn(@RequestParam("cardId") int cardId){

        return transactionService.getAllTxn(cardId);
    }

}
