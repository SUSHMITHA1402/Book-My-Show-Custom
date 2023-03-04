package com.example.Book_My_Show_Custom.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String password;

    private int age;

    @Column(unique = true,nullable = false)
    private String email;

    @NonNull
    @Column(unique = true)
    private String mobileNo;

    private String address;

    //User is the parent wrt the tickets
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> bookedTickets = new ArrayList<>();

}
