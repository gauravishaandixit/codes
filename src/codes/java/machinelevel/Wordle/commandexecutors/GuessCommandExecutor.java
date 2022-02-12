package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

import java.util.List;

public class GuessCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "guess";

    public GuessCommandExecutor(WordleService wordleService) {
        super(wordleService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(Command command) {
        if(validate(command)) {
            List<String> params = command.getParams();
            wordleService.guessWord(params.get(0), params.get(1));
        } else {
            System.out.println("Invalid Command");
        }
    }
}
