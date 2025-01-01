package org.practica1.controller;

import org.practica1.model.ICommand;
import org.practica1.model.ParametrizedCommandFactory;
import org.practica1.model.commands.*;

public class CommandFactory implements ParametrizedCommandFactory {
    public ICommand getCommand(CommandNames type) {
        ICommand command;
        switch (type) {
            case LOGIN:
                command = new LoginCommand();
                break;
            case LOGOUT:
                command = new LogoutCommand();
                break;
            case CREATE_USER:
                command = new RegisterUserCommand();
                break;
            case CREATE_PLAN:
                command = new CreatePlanCommand();
                break;
            case EXIT:
                command = new ExitCommand();
                break;
            case CREATE_ACTIVITY:
                command = new CreateActivityCommand();
                break;
            case JOIN_PLAN:
                command = new JoinPlanCommand();
                break;
            case VIEW_USER_PLANS:
                command = new ViewSubscribedPlansCommand();
                break;
            case LIST_PLANS:
                command = new ListPlansCommand();
                break;
            case DELETE_PLAN:
                command = new DeletePlanCommand();
                break;
            case ADD_ACTIVITY_TO_PLAN:
                command = new AddActivityToPlanCommand();
                break;
            case REMOVE_ACTIVITY_FROM_PLAN:
                command = new RemoveActivityFromPlanCommand();
                break;
            case LEAVE_PLAN:
                command = new LeavePlanCommand();
                break;
            case LIST_ACTIVITIES:
                command = new ViewAllActivitiesCommand();
                break;
            case LIST_USERS:
                command = new ViewRegisteredUsersCommand();
                break;
            case LIST_AVAILABLE_PLANS:
                command = new ListAvailablePlansCommand();
                break;
            case LIST_OWNED_PLANS:
                command = new ViewOwnedPlansCommand();
                break;
            case LIST_COMMANDS:
                command = new HelpCommand();
                break;
            default:
                command = null;
        }
        return command;
    }
    //d
}
