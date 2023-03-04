package com.example.Book_My_Show_Custom.Controllers;

import com.example.Book_My_Show_Custom.EntrryDtos.UserEntryDto;
import com.example.Book_My_Show_Custom.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody  UserEntryDto userEntryDto)throws Exception{
        try{
            String response = userService.addUser(userEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "User could not be added";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update_password")
    public ResponseEntity<String> updatePassword(@RequestParam("id") int id,@RequestParam("pwd") String newPassword)throws Exception{
        try{
            String response = userService.updatePassword(id,newPassword);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "Password Not Updated";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }

}
