package com.cars24.csms.data.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Table(name= "customers")
@Entity
@Data
public class CustomerEntity {

    @Id
    @Column(name="customer_id")
    private int customerId;

    @Column(name="name")
    private String Name;

    @Column(name="email")
    private String Email;

    @Column(name="phone")
    private String Phone;


    @Column(name="address")
    private String Address;

}
