package codes.java.machinelevel.PropertyHunt.modes;

import codes.java.machinelevel.PropertyHunt.commands.CommandExecutor;
import codes.java.machinelevel.PropertyHunt.commands.CommandExecutorFactory;
import codes.java.machinelevel.PropertyHunt.model.Command;

public abstract class Mode {
    private final CommandExecutorFactory commandExecutorFactory;

    public Mode(CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }

    protected void processCommand(final Command command) {
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            System.out.println();
        }
    }

    public abstract void process();
}
