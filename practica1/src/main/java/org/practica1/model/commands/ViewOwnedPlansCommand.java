package org.practica1.model.commands;

import org.practica1.controller.DB.PlanController;
import org.practica1.controller.DB.UserController;
import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.Plan;
import org.practica1.model.messages.ErrorMessage;
import org.practica1.model.messages.GenericMessage;
import org.practica1.view.PlanView;

import java.util.ArrayList;

public class ViewOwnedPlansCommand implements ICommand {
    @Override
    public Message execute(String parametros){
        Message message = new GenericMessage("");
        ArrayList<Plan> ownedPlans = new ArrayList<>();
        UserController userController = new UserController();
        PlanController planController = new PlanController();
        PlanView planView = new PlanView();
        if(userController.someoneIsLoggedIn()){
            if(planController.exists(1)){ //Si hay por lo menos uno
                for(Plan plan : planController.getPlans()){
                    if(plan.getOwner().equals(userController.getLoggedUser())){
                        ownedPlans.add(plan);
                    }
                }
                if(!ownedPlans.isEmpty()) {
                    planView.listPlans(ownedPlans);
                }else{
                    message = ErrorMessage.USER_HAS_NO_OWNED_PLANS;
                }
            }else{
                message = ErrorMessage.THERE_ARE_NO_PLANS;
            }
        }else{
            message = ErrorMessage.USER_NOT_LOGGED_IN;
        }
        return message;
    }
    //dd
}
