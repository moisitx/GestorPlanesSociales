package org.practica1.model.commands;

import org.practica1.controller.DB.ActivityController;
import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.Activity;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.Plan;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;

public class RemoveActivityFromPlanCommand implements ICommand {
    @Override
    public Message execute(String parametros){
        UserController userController = new UserController();
        PlanController planController = new PlanController();
        ActivityController activityController = new ActivityController();
        Message message = new GenericMessage("");
        String[] params = parametros.split(";");
        int planId = 0;
        int activityId = 0;
        if (userController.someoneIsLoggedIn()) {
            if (params.length != 2) {
                message = ErrorMessage.WRONG_NUMBER_OF_ARGUMENTS;
            } else {
                try {
                    planId = Integer.parseInt(params[0]);
                    activityId = Integer.parseInt(params[1]);
                } catch (NumberFormatException e) {
                    message = new GenericMessage("Error: Wrong format of arguments, check the id");
                    planId = 0;
                    activityId = 0;
                }
            }
            if (activityId > 0 && planId > 0) {
                Plan plan = planController.selectPlan(planId);
                Activity activity = activityController.selectActivity(activityId);
                if (plan != null) {
                    if (activity != null){
                        if(plan.getOwner().equals(userController.getLoggedUser())){
                            if(plan.getActivities().contains(activity)) {
                                plan.getActivities().remove(activity);
                                message = SuccessMessage.ACTIVITY_REMOVED_FROM_PLAN;
                            }else{
                                message = ErrorMessage.ACTIVITY_NOT_IN_PLAN;
                            }
                        }else{
                            message = ErrorMessage.USER_NOT_OWNER;
                        }
                    }else{
                        message = ErrorMessage.ACTIVITY_NOT_FOUND;
                    }
                } else {
                    message = ErrorMessage.PLAN_NOT_FOUND;
                }
            }else{
                message = ErrorMessage.CANT_REMOVE_ACTIVITY_FROM_PLAN;
            }
        } else {
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //d
}
