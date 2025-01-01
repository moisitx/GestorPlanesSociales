package org.practica1.model.commands;

import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;
public class HelpCommand implements ICommand{
    @Override
    public Message execute(String parametros){

        System.out.println("Sintaxis: logout");
        System.out.println("Sintaxis: login:username;password");
        System.out.println("Sintaxis: exit");
        System.out.println("Sintaxis: create-user:username;password");
        System.out.println("Sintaxis: create-plan:date;name;place;capacity");
        System.out.println("Sintaxis: create-activity:type;name;description;duration;price;capacity");
        System.out.println("Sintaxis: join-plan:planId");
        System.out.println("Sintaxis: view-user-plans:name");
        System.out.println("Sintaxis: list-plans:name");
        System.out.println("Sintaxis: delete-plan:planId");
        System.out.println("Sintaxis: add-activity-to-plan:planId;activityId");
        System.out.println("Sintaxis: remove-activity-from-plan:planId;activityId");
        System.out.println("Sintaxis: leave-plan:planId");
        System.out.println("Sintaxis: list-activities:name");
        System.out.println("Sintaxis: list-users:name");
        System.out.println("Sintaxis: list-available-plans:name");
        System.out.println("Sintaxis: list-owned-plans:name");
        System.out.println("Sintaxis: list-commands:help");

        return new GenericMessage("Comandos disponibles mostrados.");
    }
    //d
}
