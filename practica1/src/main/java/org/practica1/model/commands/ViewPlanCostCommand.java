package org.practica1.model.commands;

import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.Plan;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;
import org.practica1.view.PlanView;

public class ViewPlanCostCommand implements ICommand {
    @Override
    public Message execute(String parametros) {
        UserController userController = new UserController();
        PlanController planController = new PlanController();
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
                    double coste = plan.getTotalCost(userController.getLoggedUser());
                    message = new GenericMessage("The total cost of the plan is: " + coste +"€");
                } else {
                    message = ErrorMessage.PLAN_NOT_FOUND;
                }
            }else{
                message = new GenericMessage("Error: Can't get the cost of the plan");
            }
        } else {
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //dds
}
