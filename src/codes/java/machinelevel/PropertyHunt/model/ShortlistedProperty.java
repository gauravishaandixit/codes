package codes.java.machinelevel.PropertyHunt.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortlistedProperty {
    HashMap<String, List<Integer>> shortListedProperty;

    public ShortlistedProperty() {
        shortListedProperty = new HashMap<>();
    }

    public void shortListProperty(String userName, int id) {
        shortListedProperty.computeIfAbsent(userName, k -> new ArrayList<>()).add(id);
    }

    public List<Integer> showShortlistedProperty(String username) {
        if(shortListedProperty.containsKey(username))
            return shortListedProperty.get(username);
        else {
            return new ArrayList<>();
        }
    }
}
