package codes.java.machinelevel.FlipFit.model;

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
            List<DaySlot> daySlotsOfDate = daySlots.stream().filter(it -> it.date.equals(date)).collect(Collectors.toList());

        }
    }
}
