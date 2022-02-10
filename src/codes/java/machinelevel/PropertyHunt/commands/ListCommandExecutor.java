package codes.java.machinelevel.PropertyHunt.commands;

import codes.java.machinelevel.PropertyHunt.model.Command;
import codes.java.machinelevel.PropertyHunt.service.PropertyHuntService;

public class ListCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "list";

    public ListCommandExecutor(PropertyHuntService propertyHuntService) {
        super(propertyHuntService);
    }

    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void execute(Command command) {

    }
}
