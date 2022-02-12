package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

public abstract class CommandExecutor {
    protected WordleService wordleService;

    public CommandExecutor(WordleService wordleService) {
        this.wordleService = wordleService;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
