package org.practica1.model.commands;

import org.practica1.model.*;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.messages.SuccessMessage;


public class JoinPlanCommand implements ICommand {
    @Override
    public Message execute(String parametros) {
        PlanController planController = new PlanController();
        UserController userController = new UserController();
        Message message = new GenericMessage("");
        String[] params = parametros.split(";");
        int id = 0;
        if (userController.someoneIsLoggedIn()) {
            if (params.length != 1) {
                message = ErrorMessage.WRONG_NUMBER_OF_ARGUMENTS;
            } else {
                try {
                    id = Integer.parseInt(params[0]);
                } catch (NumberFormatException e) {
                    message = new GenericMessage("Error: Wrong format of arguments, check the id");
                    id = 0;
                }
            }
            if (id > 0) {
                Plan plan = planController.selectPlan(id);
                if (plan != null) {
                    if(plan.getUsers().contains(userController.getLoggedUser())){
                        message = ErrorMessage.USER_ALREADY_SUBSCRIBED_IN_PLAN;
                    }else{
                        if (plan.getCapacity() > 0) {
                            boolean sameDate = false;
                            for(Plan datePlan : planController.getPlans()){
                                if(datePlan.getUsers().contains(userController.getLoggedUser())){
                                    if(datePlan.getDateAndTime().equals(plan.getDateAndTime())){
                                        sameDate = true;
                                    }
                                }
                            }
                            if(sameDate){
                                message = ErrorMessage.USER_ALREADY_SUBSCRIBED_IN_PLAN_AT_SAME_TIME;
                            }else{
                                plan.getUsers().add(userController.getLoggedUser());
                                message = SuccessMessage.USER_SUBSCRIBED_IN_PLAN;
                                plan.setCapacity(plan.getCapacity() - 1);
                            }
                        } else {
                            message = ErrorMessage.PLAN_FULL;
                        }
                    }
                } else {
                    message = ErrorMessage.PLAN_NOT_FOUND;
                }
            }else{
                message = ErrorMessage.CANT_ADD_USER_TO_PLAN;
            }
        } else {
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
        //dd
    }
}
