package codes.java.machinelevel.FlipFit.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlipFitSlots {
    Map<Space, List<DaySlot>> flipFitSlots;

    public FlipFitSlots() {
        flipFitSlots = new HashMap<>();
    }

    public void getSlotsOfDateAndPlace(String location, String date) {
        Space space = new Space(location);
        if (flipFitSlots.containsKey(space)){
            List<DaySlot> daySlots = flipFitSlots.get(space);
            List<DaySlot> daySlotsOfDate = daySlots.stream().filter(it -> it.getDate().equals(date)).collect(Collectors.toList());

        }

    }

    public boolean addNewSpace(String spaceName) {
        spaceName = spaceName.toUpperCase();
        Space space = new Space(spaceName);
        if(!flipFitSlots.containsKey(space)) {
            flipFitSlots.put(space, new ArrayList<>());
            return true;
        }
        return false;
    }

    DaySlot getWorkoutDetails(String location, String date) {
        location = location.toUpperCase();
        Space space = new Space(location);
        if(flipFitSlots.containsKey(space)) {
            List<DaySlot> daySlots = flipFitSlots.get(space);
            return daySlots.stream().filter(it -> it.getDate().equals(date)).findFirst().orElse(null);
        } else {
            System.out.println("No space found with name [" + location + "]");
            return null;
        }
    }
}
