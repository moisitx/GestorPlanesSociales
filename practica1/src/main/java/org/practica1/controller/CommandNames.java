package org.practica1.controller;

public enum CommandNames {
    LOGIN("login", ": Accede a la Gestión de Planes Sociales."),
    LOGOUT("logout", ": Cierra la sesión de Gestión de Planes Sociales."),
    CREATE_USER("create-user", ": Permite crear usuarios."),
    EXIT("exit", ": Permite salir de la aplicación."),
    CREATE_PLAN ("create-plan",": Permite crear planes de actividades."),
    CREATE_ACTIVITY ("create-activity", ": Permite crear actividades."),
    JOIN_PLAN ("join-plan",": Permite unirse a un plan de actividades."),
    VIEW_USER_PLANS ("view-user-plans",": Permite ver los planes de actividades de un usuario."),
    LIST_PLANS ("list-plans",": Permite ver todos los planes."),
    DELETE_PLAN ("delete-plan",": Permite eliminar un plan de actividades."),
    ADD_ACTIVITY_TO_PLAN ("add-activity-to-plan",": Permite añadir una actividad a un plan de actividades."),
    REMOVE_ACTIVITY_FROM_PLAN ("remove-activity-from-plan",": Permite eliminar una actividad de un plan de actividades."),
    LEAVE_PLAN ("leave-plan",": Permite abandonar un plan de actividades."),
    LIST_ACTIVITIES ("list-activities",": Permite ver todas las actividades."),
    LIST_USERS ("list-users",": Permite ver todos los usuarios."),
    LIST_AVAILABLE_PLANS ("list-available-plans",": Permite ver todos los planes de actividades disponibles."),
    LIST_OWNED_PLANS ("list-owned-plans",": Permite ver todos los planes de actividades creados por el usuario."),
    LIST_COMMANDS("list-commands", ": Muestra los comandos y la sintaxis.");


    private final String command;
    private final String help;

    CommandNames (String command, String help) {
        this.command = command;
        this.help = help;
    }

    public static CommandNames fromValue(String value) {
        for (CommandNames command : CommandNames.values()) {
            if (command.getCommand().equals(value)) {
                return command;
            }
        }
        throw new UnsupportedOperationException("Comando '" + value + "' no existe.");
    }

    public String getCommand() {
        return this.command;
    }

    public String getHelp() {
        return this.getCommand() + this.help;
    }
    //d
}
