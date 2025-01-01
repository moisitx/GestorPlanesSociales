package org.practica1.view;

import org.practica1.model.User;

import java.util.ArrayList;

public class UserView {

    private User user;

    public void display(User user){
        System.out.println("User: " + user.getUsername() + " " + user.getId() + " " + user.getAge());
    }

    //d

    public void listUsers(ArrayList<User> users){
        for (User user: users) {
            display(user);
        }
    }
    //d
}
