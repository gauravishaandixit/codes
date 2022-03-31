package codes.java.machinelevel.FlipFit.service;

import codes.java.machinelevel.FlipFit.model.BookedSlots;
import codes.java.machinelevel.FlipFit.model.FlipFitSlots;
import codes.java.machinelevel.FlipFit.model.Users;

public class FlipFitService {

    BookedSlots bookedSlots;
    Users users;
    FlipFitSlots flipFitSlots;

    public FlipFitService() {
        bookedSlots = new BookedSlots();
        users = new Users();
        flipFitSlots = new FlipFitSlots();
    }

    public void register(String name) {
        name = name.toUpperCase();
        if(users.addNewUser(name)) {
            System.out.println("User [" + name + "] is added.");
        } else {
            System.out.println("User [" + name + "] was not added.");
        }
    }

    public void viewWorkoutDetails(String location, String date) {

    }

    public void bookSlot(String userName, String location, String date, String time) {

    }

    public void viewWorkoutPlan(String userName, String date) {

    }

    public void addNewSpace(String spaceName) {
        boolean result = flipFitSlots.addNewSpace(spaceName);
        if(result) {
            System.out.println("Space [" + spaceName + "] was added.");
        } else {
            System.out.println("Space [" + spaceName + "] was not added.");
        }
    }

}
