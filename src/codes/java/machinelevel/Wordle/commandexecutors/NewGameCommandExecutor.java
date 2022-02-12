package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

public class NewGameCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "new_game";

    public NewGameCommandExecutor(WordleService wordleService) {
        super(wordleService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        if(validate(command)) {
            wordleService.startNewRound();
        } else {
            System.out.println("Invalid Command");
        }
    }
}
