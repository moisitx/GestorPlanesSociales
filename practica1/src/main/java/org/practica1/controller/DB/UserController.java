package org.practica1.controller.DB;

import org.practica1.controller.DB.DB;
import org.practica1.model.User;

import java.util.ArrayList;

public class UserController {
    private final ArrayList<User> users = DB.users;

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
    public boolean exists(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public User selectUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public User selectUser(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }
    public User selectUserByTlf(int tlf) {
        for (User user : users) {
            if (user.getTlf() == tlf) {
                return user;
            }
        }
        return null;
    }
    public void logoutAll() {
        for (User user : users) {
            user.logOut();
        }
    }
    public boolean someoneIsLoggedIn() {
        boolean result = false;
        for (User user : users) {
            if(user.isLoggedIn()){
                result = true;
            }
        }
        return result;
    }
    public User getLoggedUser() {
        User loggedUser = null;
        boolean result = false;
        for (User user : users) {
            if(user.isLoggedIn()){
                loggedUser = user;
            }
        }
        return loggedUser;
    }
    public int getSize(){
        return this.users.size();
    }
    public ArrayList<User> getUsers() {
        return this.users;
    }
    //d
    //d
}
