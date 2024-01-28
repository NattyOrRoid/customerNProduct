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
    @Column(name = "First Name")
    private String fName;
    @Column(name = "Last Name")
    private String lName;
    @Column(name = "Office Mail")
    private String officeMail;
    @Column(name = "Personal Mail")
    private String personalMail;
    @Column(name = "Family Member")
    private String famMember;
    
}
