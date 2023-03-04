package com.example.Book_My_Show_Custom.Services;

import com.example.Book_My_Show_Custom.Convertors.UserConvertor;
import com.example.Book_My_Show_Custom.Entities.UserEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.UserEntryDto;
import com.example.Book_My_Show_Custom.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception,NullPointerException{

        UserEntity user = UserConvertor.convertDtoToEntity(userEntryDto);

        userRepository.save(user);

        return "User added Successfully";
    }

    public String updatePassword(int id,String password)throws Exception,NullPointerException{
        UserEntity user = userRepository.findById(id).get();
        user.setPassword(password);
        userRepository.save(user);
        return "Password Updated Successfully";
    }
}
