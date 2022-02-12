package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

public class RegisterUserCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "register_user";

    public RegisterUserCommandExecutor(WordleService wordleService) {
        super(wordleService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        if(validate(command)) {
            wordleService.registerNewUser(command.getParams().get(0));
        } else {
            System.out.println("Invalid Command");
        }
    }
}
