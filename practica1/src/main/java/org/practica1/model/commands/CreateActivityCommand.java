package org.practica1.model.commands;

import org.practica1.controller.DB.ActivityController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.*;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;

public class CreateActivityCommand implements ICommand {
    @Override
    public Message execute(String parametros) {
        ActivityController activityController = new ActivityController();
        UserController userController = new UserController();
        Message message;
        String[] params = parametros.split(";");
        String type = "";
        String name = "";
        String description = "";
        int duration = 0;
        double price = 0;
        int capacity = 0;
        if(userController.someoneIsLoggedIn()){
            if(params.length != 6){
                message = ErrorMessage.WRONG_NUMBER_OF_ARGUMENTS;
            }else{
                type = params[0];
                name = params[1];
                description = params[2];
                try{
                    duration = Integer.parseInt(params[3]);
                    price = Double.parseDouble(params[4]);
                    capacity = Integer.parseInt(params[5]);

                }catch(NumberFormatException e){
                    message = new GenericMessage("Error: Wrong format of arguments, check the price, duration and capacity");
                    duration = 0;
                    price = 0.0;
                    capacity = 0;
                }
            }
            if(duration > 0 && price > 0 && capacity > 0){
                if(type.equals("Cinema")){
                    activityController.addActivity(new CinemaActivity(name, description, duration, price, capacity));
                    message = SuccessMessage.ACTIVITY_CREATED;
                }else if(type.equals("Theatre")){
                    activityController.addActivity(new TheatreActivity(name, description, duration, price, capacity));
                    message = SuccessMessage.ACTIVITY_CREATED;
                }else if (type.equals("Generic")){
                    activityController.addActivity(new GenericActivity(name, description, duration, price, capacity));
                    message = SuccessMessage.ACTIVITY_CREATED;
                }else{
                    message = ErrorMessage.ACTIVITY_TYPE_NOT_VALID;
                }
            }else{
                message = ErrorMessage.ACTIVITY_NOT_CREATED;
            }
        }else{
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //dd

}
