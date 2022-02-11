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
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        if(validate(command)) {
            propertyHuntService.showShortlistedProperty(command.getParams().get(0));
        } else {
            System.out.println("Invalid Command");
        }
    }
}
