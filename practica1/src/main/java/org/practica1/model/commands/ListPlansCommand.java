package org.practica1.model.commands;

import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.*;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;
import org.practica1.view.PlanView;

public class ListPlansCommand implements ICommand {
    @Override
    public Message execute(String parametros) {
        Message message = new GenericMessage("");
        UserController userController = new UserController();
        PlanController planController = new PlanController();
        PlanView planView = new PlanView();
        if(userController.someoneIsLoggedIn()){
            if(planController.exists(1)){ //Si hay por lo menos uno
                planView.listPlans(planController.getPlans());
            }else{
                message = ErrorMessage.THERE_ARE_NO_PLANS;
            }
        }else{
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //d
}
