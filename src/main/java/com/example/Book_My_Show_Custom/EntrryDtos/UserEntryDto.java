package com.example.Book_My_Show_Custom.EntrryDtos;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class UserEntryDto {

    private String name;

    private int age;

    private String password;

    private String email;

    private String mobileNo;

    private String address;
}
