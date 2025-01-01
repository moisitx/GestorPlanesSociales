package org.practica1.model.commands;

import org.practica1.model.ICommand;
import org.practica1.model.Message;
import org.practica1.model.messages.GenericMessage;
import org.practica1.model.messages.SuccessMessage;

public class ExitCommand implements ICommand {
    @Override
    public Message execute(String parametros){
        Message message;
        //System.exit(0);
        message = SuccessMessage.EXIT;
        return message;
    }
    //dd
}
