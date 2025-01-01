package org.practica1.model.commands;

import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.Plan;
import org.practica1.model.User;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.view.PlanView;

import java.util.ArrayList;

public class ViewSubscribedPlansCommand implements ICommand {
    @Override
    public Message execute(String parametros) {
        UserController userController = new UserController();
        PlanController planController = new PlanController();
        ArrayList<Plan> subscribedPlans = new ArrayList<>();
        PlanView planView = new PlanView();
        Message message = new GenericMessage("");
        String[] params = parametros.split(";");
        String name = "";
        User user = null;
        if (userController.someoneIsLoggedIn()) {
            if (params.length != 1) {
                message = ErrorMessage.WRONG_NUMBER_OF_ARGUMENTS;
            } else {
                name = params[0];
                if(userController.selectUser(name) != null) {
                    user = userController.selectUser(name);
                    for(Plan plan : planController.getPlans()){
                        if(plan.getUsers().contains(user)){
                            subscribedPlans.add(plan);
                        }
                    }
                    if(!subscribedPlans.isEmpty()) {
                        planView.listPlans(subscribedPlans);
                    }else{
                        message = ErrorMessage.USER_NOT_SUBSCRIBED_IN_PLAN;
                    }
                }else{
                    message = ErrorMessage.USER_NOT_FOUND;
                }
            }
        } else {
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //view-subscribed-plans:salvaa
}
