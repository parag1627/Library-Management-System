package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO;


import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponseDTO {

    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private Date transactionDate;
    private boolean isIssueOperation;
    private String message;
}
