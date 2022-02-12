package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

public class ResetRoundCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "reset";

    public ResetRoundCommandExecutor(WordleService wordleService) {
        super(wordleService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {

    }
}
