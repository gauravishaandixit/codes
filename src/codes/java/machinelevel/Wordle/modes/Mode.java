package codes.java.machinelevel.Wordle.modes;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

public abstract class Mode {

    protected WordleService wordleService;

    public Mode(WordleService wordleService) {
        this.wordleService = wordleService;
    }

    protected void processCommand(Command command) {

    }
    public abstract void process();
}
