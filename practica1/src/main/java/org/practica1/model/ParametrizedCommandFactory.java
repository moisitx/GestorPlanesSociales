package org.practica1.model;

import org.practica1.controller.CommandNames;

public interface ParametrizedCommandFactory {
    public ICommand getCommand(CommandNames type);
    //d
}
