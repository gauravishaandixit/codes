package codes.java.machinelevel.PropertyHunt.commands;

import codes.java.machinelevel.PropertyHunt.model.Command;
import codes.java.machinelevel.PropertyHunt.service.PropertyHuntService;

public class ShortlistCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "shortlist";

    public ShortlistCommandExecutor(PropertyHuntService propertyHuntService) {
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
