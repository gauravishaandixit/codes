package codes.java.machinelevel.FlipFit;

import codes.java.machinelevel.FlipFit.service.FlipFitService;

public class Main {
    public static void main(String[] args) {
        FlipFitService flipFitService = new FlipFitService();

        flipFitService.register("user1");
        flipFitService.register("user2");
        flipFitService.register("user3");


    }
}
