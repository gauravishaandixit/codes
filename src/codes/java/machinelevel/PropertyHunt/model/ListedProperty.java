package codes.java.machinelevel.PropertyHunt.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ListedProperty {
    HashMap<String, Set<Integer>> listedProperty;
    List<Property> properties;

    public ListedProperty() {
        listedProperty = new HashMap<>();
        properties = new ArrayList<>();
    }

    public void listProperty(List<String> propertyInfo) {

    }

    public Property getProperty(int id) {
        if (id < properties.size()) {
            return properties.get(id);
        }
        return null;
    }

    public int sellProperty(String username, int id) {
        if(listedProperty.containsKey(username)) {
            if(listedProperty.get(username).contains(id)) {
                return 0;
            } else {
                return 1;
            }
        }
        return 2;
    }
}
