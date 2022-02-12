package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

public class TotalScoreCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "total_scores";

    public TotalScoreCommandExecutor(WordleService wordleService) {
        super(wordleService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        if(validate(command)) {
            wordleService.getAllRoundScores();
        } else {
            System.out.println("Invalid Command");
        }
    }
}
