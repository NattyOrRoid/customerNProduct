package com.etiqa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "")
@Getter
@Setter
public class Customer {

    private long id;
    private String fName;
    private String lName;
    private String officeMail;
    private String personalMail;
    
}
