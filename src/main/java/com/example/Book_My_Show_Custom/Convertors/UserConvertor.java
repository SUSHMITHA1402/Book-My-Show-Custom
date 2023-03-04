package com.example.Book_My_Show_Custom.Convertors;

import com.example.Book_My_Show_Custom.Entities.UserEntity;
import com.example.Book_My_Show_Custom.EntrryDtos.UserEntryDto;

public class UserConvertor {

    //Static is kept to avoid calling it using via objects
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        UserEntity userEntity = UserEntity.builder().
                age(userEntryDto.getAge()).
                address(userEntryDto.getAddress()).
                name(userEntryDto.getName()).
                password(userEntryDto.getPassword()).
                email(userEntryDto.getEmail()).
                mobileNo(userEntryDto.getMobileNo()).
                build();

        return userEntity;
    }


}
