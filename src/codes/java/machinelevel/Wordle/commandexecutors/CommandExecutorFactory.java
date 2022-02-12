package codes.java.machinelevel.Wordle.commandexecutors;

import codes.java.machinelevel.Wordle.services.WordleService;

import java.util.HashMap;

public class CommandExecutorFactory {
    private final WordleService wordleService;

    HashMap<String, CommandExecutor> commandExecutors;

    public CommandExecutorFactory(WordleService wordleService) {
        this.wordleService = wordleService;
        commandExecutors = new HashMap<>();

        commandExecutors.put(AddWordCommandExecutor.COMMAND_NAME, new AddWordCommandExecutor(wordleService));
        commandExecutors.put(NewGameCommandExecutor.COMMAND_NAME, new NewGameCommandExecutor(wordleService));
        commandExecutors.put(RegisterUserCommandExecutor.COMMAND_NAME, new RegisterUserCommandExecutor(wordleService));
        commandExecutors.put(GuessCommandExecutor.COMMAND_NAME, new GuessCommandExecutor(wordleService));
        commandExecutors.put(TotalScoreCommandExecutor.COMMAND_NAME, new TotalScoreCommandExecutor(wordleService));
        commandExecutors.put(ResetRoundCommandExecutor.COMMAND_NAME, new ResetRoundCommandExecutor(wordleService));
        commandExecutors.put(CurrentRoundScoreCommandExecutor.COMMAND_NAME, new CurrentRoundScoreCommandExecutor(wordleService));
    }

    public CommandExecutor getCommandExecutor(String commandName) {
        return commandExecutors.get(commandName);
    }
}
