package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.IssueBookRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.IssueBookResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.TransactionResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Book;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.LibraryCard;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Transaction;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.CardStatus;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.TransactionStatus;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository.BookRepository;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository.LibraryCardRepository;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository.TransactionRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {



    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    LibraryCardRepository libraryCardRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private JavaMailSender emailSender;

    public IssueBookResponseDTO issueBook (IssueBookRequestDTO issueBookRequestDTO) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactionNo(String.valueOf(UUID.randomUUID()));
        transaction.setIssuedOperation(true);



        LibraryCard card;
        try {
            card = libraryCardRepository.findById(issueBookRequestDTO.getCardId()).get();
        }
        catch (Exception e){

            transaction.setTransactionStatus(TransactionStatus.FAILED);


            transaction.setMessage("Invalid card Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card Id");
        }

        Book book;
        try {
            book = bookRepository.findById(issueBookRequestDTO.getBookId()).get();
        }
        catch (Exception e){

            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid book Id");
        }
        transaction.setBook(book);
        transaction.setCard(card);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("Your Card is Not Activated");
            transactionRepository.save(transaction);
            throw new Exception("Your Card is Not Activated");
        }
        if(book.isIssued()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMessage("Book is not Available");
            transactionRepository.save(transaction);
            throw new Exception("Book is not Available");

        }

        // I can issue the book
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was succesfull");
        book.setIssued(true);
        book.getTransaction().add(transaction);
        book.setCard(card);
        card.getTransactionList().add(transaction);
        card.getBookIssued().add(book);


        libraryCardRepository.save(card);// will save book and transaction also

   IssueBookResponseDTO issueBookResponseDTO = new IssueBookResponseDTO();
      issueBookResponseDTO.setTransactionId(transaction.getTransactionNo());
      issueBookResponseDTO.setBookName(book.getTitle());
      issueBookResponseDTO.setTransactionStatus(TransactionStatus.SUCCESS);

      //String text = "Congrats !!." + " " + card.getStudent().getName() + "You Have an Issued a"+ book.getTitle()+ "Book";
        String text = "Congratulations" + card.getStudent().getName()+ " For  Not being  promoted to the  next league in " + book.getTitle()+ "and due to some illegal activities were happen during the match between PORTUGAL , so we have take a decision to terminate Your Profile  Profile Id is [Tombhai18].  Please Donot reply This is Company Generated email Thank You";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("springbackend98@gmail.com");
        message.setTo(card.getStudent().getEmail());
        //message.setSubject("Issue Book Notification");
        message.setSubject("PES Notification And warning Regarding Haland");
        message.setText(text);
        emailSender.send(message);

      return issueBookResponseDTO;
    }
    public List<TransactionResponseDTO> getAllTxn(int cardId) {
         List<Transaction> transactionList = transactionRepository.getAllSuccessfulTxnCardId(cardId);

         List<TransactionResponseDTO> transactionResponseDTOS = new ArrayList<>();
         for(Transaction t : transactionList){
             TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
             transactionResponseDTO.setTransactionNumber(t.getTransactionNo());
             transactionResponseDTO.setTransactionDate(t.getTransactionDate());
             transactionResponseDTO.setTransactionStatus(t.getTransactionStatus());
             transactionResponseDTO.setMessage(t.getMessage());
             transactionResponseDTO.setIssueOperation(true);
            transactionResponseDTOS.add(transactionResponseDTO);
         }
         return transactionResponseDTOS;
    }
//        List<Transaction> transactionList = transactionRepository.getAllSuccessfulTxnCardId(cardId);
//        String ans ="";
//        for(Transaction t : transactionList){
//            ans+= t.getTransactionNo();
//            ans+="\n";
//        }
//        return ans;
//    }
    }
