package com.etiqa.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private long id;
    private String fName;
    private String lName;
    private String officeMail;
    private String personalMail;
    private String famMember;
}
