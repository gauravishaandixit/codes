package codes.java.machinelevel.PropertyHunt.commands;

import codes.java.machinelevel.PropertyHunt.model.Command;
import codes.java.machinelevel.PropertyHunt.service.PropertyHuntService;

public abstract class CommandExecutor {
    protected final PropertyHuntService propertyHuntService;

    public CommandExecutor(PropertyHuntService propertyHuntService) {
        this.propertyHuntService = propertyHuntService;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
