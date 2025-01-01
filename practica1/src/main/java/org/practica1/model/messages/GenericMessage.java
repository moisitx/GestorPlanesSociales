package org.practica1.model.messages;

import org.practica1.model.Message;

public class GenericMessage implements Message {
    private final String content;
    public GenericMessage(String message){
        this.content = "Message: " + message;
    }
    @Override
    public String getContent(){
        return this.content;
    }
}
