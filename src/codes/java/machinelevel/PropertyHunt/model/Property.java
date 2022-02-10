package codes.java.machinelevel.PropertyHunt.model;

public class Property {
    String location;
    int area;
    int lowerPrice;
    int upperPrice;
    ListType listType;
    Status status;
    int noOfRooms;
    String propertyName;

    public Property() {
    }

    public Property(String location, int area, int lowerPrice, int upperPrice, ListType listType, Status status, int noOfRooms, String propertyName) {
        this.location = location;
        this.area = area;
        this.lowerPrice = lowerPrice;
        this.upperPrice = upperPrice;
        this.listType = listType;
        this.status = status;
        this.noOfRooms = noOfRooms;
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public int getArea() {
        return area;
    }

    public int getLowerPrice() {
        return lowerPrice;
    }

    public int getUpperPrice() {
        return upperPrice;
    }

    public ListType getListType() {
        return listType;
    }

    public Status getStatus() {
        return status;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String toString() {
        return "Property{" +
                "location='" + location + '\'' +
                ", area=" + area +
                ", lowerPrice=" + lowerPrice +
                ", upperPrice=" + upperPrice +
                ", listType=" + listType +
                ", status=" + status +
                ", noOfRooms=" + noOfRooms +
                ", propertyName='" + propertyName + '\'' +
                '}';
    }
}
