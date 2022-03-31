package codes.java.machinelevel.FlipFit.command;

import codes.java.machinelevel.FlipFit.model.Command;
import codes.java.machinelevel.FlipFit.service.FlipFitService;

public abstract class CommandExecutor {
    protected FlipFitService flipFitService;

    public CommandExecutor(FlipFitService flipFitService) {
        this.flipFitService = flipFitService;
    }

    abstract public void validate(Command command);

    abstract public void execute(Command command);

}
