package codes.java.machinelevel.FlipFit.model;

public class Slot {
    String time;
    SlotType slotType;
    int capacity;

    public Slot() {}

    public Slot(String time, SlotType slotType, int capacity) {
        this.time = time;
        this.slotType = slotType;
        this.capacity = capacity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }
}
