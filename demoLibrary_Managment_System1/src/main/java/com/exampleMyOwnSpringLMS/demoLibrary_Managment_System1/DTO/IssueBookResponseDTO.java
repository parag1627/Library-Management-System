package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDTO {

    private String transactionId;
    private String bookName;
    private TransactionStatus transactionStatus;
}
