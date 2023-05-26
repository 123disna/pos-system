package com.frontendpos.posfrontend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",length = 10)
    private int id;

    @Column(name = "customer_name",length = 200)
    private String name;

    @Column(name = "customer_address",length = 200)
    private String address;

    @Column(name = "phone_number",length = 200)
    private String phone;

    @Column(name = "nic",unique = true, length = 20)
    private String nic;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;

}
