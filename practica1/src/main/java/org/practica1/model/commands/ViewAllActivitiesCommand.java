package org.practica1.model.commands;

import org.practica1.controller.DB.ActivityController;
import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.view.ActivityView;
import org.practica1.view.PlanView;

public class ViewAllActivitiesCommand implements ICommand {
    @Override
    public Message execute(String parametros){
        Message message = new GenericMessage("");
        UserController userController = new UserController();
        ActivityController activityController = new ActivityController();
        ActivityView activityView = new ActivityView();
        if(userController.someoneIsLoggedIn()){
            if(activityController.exists(1)){ //Si hay por lo menos una
                activityView.listActivities(activityController.getActivities());
            }else{
                message = ErrorMessage.THERE_ARE_NO_ACTIVITIES;
            }
        }else{
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //d
}
