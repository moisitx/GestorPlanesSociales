package org.practica1.controller;

import org.practica1.model.ICommand;

import java.util.Scanner;

public class CLI {
    CommandFactory factory;
    public CLI() {
        factory = new CommandFactory();
    }
    public void runCommands() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            exit = runCommand(scanner);
        }
    }
    private boolean runCommand(Scanner scanner) {
        boolean exit = false;
        String commandInput = scanner.nextLine();
        scanner.reset();
        String[] commandParts = commandInput.split(":");
        CommandNames commandName;

        try {
            commandName = CommandNames.fromValue(commandParts[0]);
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

        if (commandName != CommandNames.EXIT) {
            ICommand command = factory.getCommand(commandName);

            if (commandName != CommandNames.LOGOUT)
                try {
                    System.out.println(command.execute(commandParts[1]).getContent());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Incomplete command");
                }
            else {
                System.out.println(factory.getCommand(CommandNames.LOGOUT).execute("").getContent());
            }
        } else {
            System.out.println(factory.getCommand(CommandNames.EXIT).execute("").getContent());
            exit = true;
        }
        return exit;
    }
    public static void main(String[] args) {
        System.out.println("Hello and welcome, introduce the desired command,");
        System.out.println("for the list of available commands and their sintaxis type: list-commands:help");
        CLI cli = new CLI();
        cli.runCommands();
    }
    //d
}