package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.Genere;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookAddRequestDTO {

    private String title;
    private int price;
    private Genere genere;
    private int authorId;
}
