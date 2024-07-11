package com.example.ElectricPeAssignment.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class User{
    private int userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

    User (String firstName, String lastName, String emailId, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public boolean equals(Object user){
        User user1 = (User)user;
        if(this.getEmailId().equals(user1.getEmailId()) || this.getPassword().equals(user1.getPassword())){
            return true;
        }
        return false;
    }
}
