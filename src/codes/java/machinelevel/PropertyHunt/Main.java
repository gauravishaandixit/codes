package codes.java.machinelevel.PropertyHunt;

import codes.java.machinelevel.PropertyHunt.commands.CommandExecutorFactory;
import codes.java.machinelevel.PropertyHunt.modes.FileMode;
import codes.java.machinelevel.PropertyHunt.modes.InteractiveMode;
import codes.java.machinelevel.PropertyHunt.service.PropertyHuntService;

public class Main {
    public static void main(String[] args) {
        PropertyHuntService propertyHuntService = new PropertyHuntService();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(propertyHuntService);

        if(isInteractiveMode(args)){
            new InteractiveMode(commandExecutorFactory).process();
        } else {
            if(isFileMode(args)) {
                new FileMode(commandExecutorFactory, args[0]).process();
            } else {
                System.out.println("Wrong Input Mode");
            }
        }

    }

    private static boolean isInteractiveMode(String[] args) {
        return args.length == 0;
    }


    private static boolean isFileMode(String[] args) {
        return args.length == 1;
    }
}
