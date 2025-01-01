package org.practica1.model.commands;

import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.SuccessMessage;

public class LogoutCommand implements ICommand {
    @Override
    public Message execute(String parametros) {
        Message message;
        UserController userController = new UserController();
        userController.logoutAll();
        if(userController.someoneIsLoggedIn()){
            message = ErrorMessage.LOGOUT_FAILED;
        } else {
            message = SuccessMessage.LOGGED_OUT;
        }
        return message;
    }
    //dd
}
