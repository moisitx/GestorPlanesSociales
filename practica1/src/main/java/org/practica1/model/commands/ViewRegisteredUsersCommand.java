package org.practica1.model.commands;

import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.view.PlanView;
import org.practica1.view.UserView;

public class ViewRegisteredUsersCommand implements ICommand {
    @Override
    public Message execute(String parametros){
        Message message = new GenericMessage("");
        UserController userController = new UserController();
        UserView userView = new UserView();
        if(userController.someoneIsLoggedIn()){
            if(userController.exists(1)){ //Si hay por lo menos uno
                userView.listUsers(userController.getUsers());
            }else{
                message = ErrorMessage.THERE_ARE_NO_REGISTERED_USERS;
            }
        }else{
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //d
}
