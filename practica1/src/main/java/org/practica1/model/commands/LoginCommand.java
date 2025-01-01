package org.practica1.model.commands;

import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.User;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.SuccessMessage;

public class LoginCommand implements ICommand {
    @Override
    public Message execute(String parameters) {
        Message message;
        String[] params = parameters.split(";");
        String username = "";
        String password = "";
        if (params.length != 2) {
            message = ErrorMessage.WRONG_NUMBER_OF_ARGUMENTS;
        }else{
            try{
                username = params[0];
                password = params[1];
            }catch(NullPointerException e){
                message = ErrorMessage.FIELD_NULL;
            }
            UserController userController = new UserController();
            User user = userController.selectUser(username);
            if (user != null && user.getPassword().equals(password) && !user.isLoggedIn()){
                user.logIn();
                message = SuccessMessage.LOGGED_IN;
            } else if (user != null && !user.getPassword().equals(password)) {
                message = ErrorMessage.WRONG_PASSWORD;
            } else if (user != null && user.isLoggedIn()) {
                message = ErrorMessage.USER_ALREADY_LOGGED_IN;
            } else {
                message = ErrorMessage.USER_NOT_FOUND;
            }
        }
        return message;
    }
    //dd
}
