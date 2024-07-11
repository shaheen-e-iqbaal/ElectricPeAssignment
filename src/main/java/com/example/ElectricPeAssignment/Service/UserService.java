package com.example.ElectricPeAssignment.Service;


import com.example.ElectricPeAssignment.Entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserService {


    ArrayList<User> users = new ArrayList<>();
    static int userId = 0;

    //Method to create the User
    public String createUser(User newUser){
        for(User user : users){
            if(user.equals(newUser)){
                return "User Already exists with this EmailId and/or Password";
            }
        }
        newUser.setUserId(userId++);
        users.add(newUser);
        return "User Created Successfully with userId = " + newUser.getUserId();
    }

    //Method to Login User
    public String login(String emailId, String password){
        boolean isAvailable = false;
        for(User user : users){
            if(user.getEmailId().equals(emailId) && user.getPassword().equals(password)){
                return "Successfully LogedIn";
            }
        }
        return "Wrong EmailId and/or Password";
    }

    //Method to get User by userId
    public User getUser(int userId){
        for(User user : users){
            if(user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}
