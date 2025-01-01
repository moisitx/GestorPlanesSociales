package org.practica1.model.commands;

import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.Plan;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreatePlanCommand implements ICommand {
    @Override
    public Message execute(String parametros) {
        PlanController planController = new PlanController();
        UserController userController = new UserController();
        Message message = new GenericMessage("");
        String[] params = parametros.split(";");
        String name = "";
        Date date = null;
        String place = "";
        int capacity = 0;

        if(userController.someoneIsLoggedIn()){
            if(params.length != 4){
                message = ErrorMessage.WRONG_NUMBER_OF_ARGUMENTS;
            } else {
                name = params[0];
                place = params[2];
                try {
                    capacity = Integer.parseInt(params[3]);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH.mm");
                    date = new Date(dateFormat.parse(params[1]).getTime());
                } catch (NumberFormatException | ParseException e) {
                    message = new GenericMessage("Error: Wrong format of arguments, check the date, duration, and capacity");
                    capacity = 0;
                }
            }

            if (capacity > 0) {
                Plan plan = new Plan(date, name, capacity, place);
                planController.addPlan(plan);
                plan.setOwner(userController.getLoggedUser());
                message = SuccessMessage.PLAN_ADDED;
            }
        } else {
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }

        return message;
    }
    //dd
}
