package codes.java.machinelevel.PropertyHunt.commands;

import codes.java.machinelevel.PropertyHunt.model.Command;
import codes.java.machinelevel.PropertyHunt.service.PropertyHuntService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private final Map<String, CommandExecutor> commands = new HashMap<>();
    PropertyHuntService propertyHuntService;

    public CommandExecutorFactory(PropertyHuntService propertyHuntService) {
        this.propertyHuntService = propertyHuntService;

        commands.put(ListCommandExecutor.COMMAND_NAME, new ListCommandExecutor(propertyHuntService));
        commands.put(SearchCommandExecutor.COMMAND_NAME, new SearchCommandExecutor(propertyHuntService));
        commands.put(ShortlistCommandExecutor.COMMAND_NAME, new ShortlistCommandExecutor(propertyHuntService));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        return commands.get(command.getCommandName());
    }
}
