package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

public class CurrentRoundScoreCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "current_scores";

    public CurrentRoundScoreCommandExecutor(WordleService wordleService) {
        super(wordleService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        if(validate(command)) {
            wordleService.getCurrentRoundScores();
        } else {
            System.out.println("Invalid Command");
        }
    }
}
