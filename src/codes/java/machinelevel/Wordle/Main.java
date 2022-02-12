package codes.java.machinelevel.Wordle;

import codes.java.machinelevel.Wordle.commandexecutors.CommandExecutorFactory;
import codes.java.machinelevel.Wordle.modes.FileMode;
import codes.java.machinelevel.Wordle.modes.HardCodedMode;
import codes.java.machinelevel.Wordle.services.WordleService;

public class Main {
    public static void main(String[] args) {
        WordleService wordleService = new WordleService();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(wordleService);

        if(isHardCodedMode(args)) {
            new HardCodedMode(wordleService, commandExecutorFactory).process();
        } else {
            if(isFileMode(args)) {
                new FileMode(commandExecutorFactory, args[0]).process();
            }
        }

    }

    static private boolean isHardCodedMode(String[] args) {
        return args.length == 0;
    }

    static private boolean isFileMode(String[] args) {
        return args.length == 1;
    }
}
