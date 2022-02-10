package codes.java.machinelevel.PropertyHunt.service;

import codes.java.machinelevel.PropertyHunt.model.ListedProperty;
import codes.java.machinelevel.PropertyHunt.model.Property;
import codes.java.machinelevel.PropertyHunt.model.ShortlistedProperty;
import codes.java.machinelevel.PropertyHunt.model.Users;

import java.util.List;

public class PropertyHuntService {

    private final ListedProperty listedProperty;
    private final ShortlistedProperty shortlistedProperty;
    private final Users users;

    public PropertyHuntService() {
        shortlistedProperty = new ShortlistedProperty();
        listedProperty = new ListedProperty();
        users = new Users();
    }

    boolean registerUser(String userName) {
        return users.addUser(userName);
    }

    void listProperty(List<String> propertyInfo) {
        listedProperty.listProperty(propertyInfo);
        System.out.println("Property Listed Successfully");
    }

    void sellProperty(String name, int propertyId) {
        int result = listedProperty.sellProperty(name, propertyId);

    }

    public void searchProperty(List<String> searchParams) {

    }

    public void shortListProperty(String username, int propertyId) {
        shortlistedProperty.shortListProperty(username, propertyId);
        System.out.println("Property Shortlisted");
    }

    public void showShortlistedProperty(String username) {
        List<Integer> shortLists = shortlistedProperty.showShortlistedProperty(username);
        for (int id: shortLists) {
            Property property = listedProperty.getProperty(id);
            if(property != null) {
                System.out.println(property);
            }
        }

        if(shortLists.size() == 0) {
            System.out.println("No Data");
        }
    }
}
