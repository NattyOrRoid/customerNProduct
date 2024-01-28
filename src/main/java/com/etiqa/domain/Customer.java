package com.etiqa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer {
    @Id
    private long id;
    @Column(name = "first_name", length =  100)
    private String fName;
    @Column(name = "last_name", length =  100)
    private String lName;
    @Column(name = "office_email", unique = true, length = 254)
    private String officeMail;
    @Column(name = "personal_email", unique = true, length = 254)
    private String personalMail;
    @Column(name = "family_member", length = 254)
    private String famMember;
    
}
