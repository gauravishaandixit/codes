package codes.java.machinelevel.Wordle.modes;

import codes.java.machinelevel.Wordle.commandexecutors.CommandExecutor;
import codes.java.machinelevel.Wordle.commandexecutors.CommandExecutorFactory;
import codes.java.machinelevel.Wordle.models.Command;

public abstract class Mode {

    private final CommandExecutorFactory commandExecutorFactory;

    public Mode(CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }

    protected void processCommand(Command command) {
        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command.getCommandName());
        commandExecutor.execute(command);
    }
    public abstract void process();
}
