package org.practica1.model.commands;

import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.Plan;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;

public class DeletePlanCommand implements ICommand {
    @Override
    public Message execute(String parametros){
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
                if(plan != null){
                    if(plan.getOwner().equals(userController.getLoggedUser())) {
                        planController.removePlan(plan);
                        message = SuccessMessage.PLAN_DELETED;
                    }else{
                        message = ErrorMessage.USER_NOT_OWNER;
                    }
                }else{
                    message = ErrorMessage.PLAN_NOT_FOUND;
                }
            }else{
                message = ErrorMessage.CANT_DELETE_PLAN;
            }
        } else {
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //d
}
