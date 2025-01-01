package org.practica1.model.commands;

import org.practica1.controller.DB.UserController;
import org.practica1.model.*;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;

public class RegisterUserCommand implements ICommand {
    UserController userController = new UserController();
    @Override
    public Message execute(String parameters) {
        String[] params = parameters.split(";");
        Message message;
        String name = "";
        int age = 0;
        int tlf = 0;
        String password = "";
        if(params.length != 4){
            message = ErrorMessage.WRONG_NUMBER_OF_ARGUMENTS;
        }else{
            name = params[0];
            password = params[3];
            try{
                tlf = Integer.parseInt(params[2]);
                age = Integer.parseInt(params[1]);
            }catch(NumberFormatException e){
                message = new GenericMessage("Error: Wrong format of arguments, check the telephone number and age");
                tlf = 0;
                age = 0;
            }
        }
        if(age > 0 && tlf > 0) {
            if(age > 14 && age < 100){
                if(password.length() > 2) {
                    if (userController.selectUser(name) != null) {
                        message = ErrorMessage.USER_ALREADY_EXISTS;
                    }else if (userController.selectUserByTlf(tlf) != null){
                        message = ErrorMessage.PHONE_ALREADY_USED;
                    }else{
                        userController.addUser(new User(name, password, age, tlf));
                        message = SuccessMessage.USER_CREATED;
                    }
                }else{
                    message = ErrorMessage.PASSWORD_NOT_SAFE;
                }
            }else{
                message = ErrorMessage.USER_NOT_CREATED;
            }
        }else{
            message = ErrorMessage.USER_NOT_CREATED;
        }
        return message;
    }
    //dd
}
