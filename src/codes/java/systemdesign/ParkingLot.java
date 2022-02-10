package codes.java.systemdesign;

import java.util.Date;
import java.util.List;
import java.util.Map;

class SlotService {
    ParkingTicket getTicket(VehicleType type, String vehicleNo) {
        int parkingSpotId = ParkingService.allocate(type, vehicleNo);
        return new ParkingTicket(vehicleNo, parkingSpotId, null, new Date());
    }

    double exit(int parkingTicketId) {
        ParkingTicket parkingTicket = new ParkingTicket();
        ParkingService.deallocate(parkingTicket.parkingSpotId);

        return PaymentService.makePayment(VehicleType.Compact, parkingTicket.from, parkingTicket.to);
    }
}

class ParkingService {
    static int allocate(VehicleType vehicleType, String vehicleNo){
        return 123;
    }

    static boolean deallocate(int id){
        return true;
    }

}

class PaymentService {
    Map<VehicleType, int[]> map;
    int amount = 10;
    int thresholdDuration = 5;
    int increaseBy = 5;
    static double makePayment(VehicleType type, Date from, Date to) {
        int hours = to.getHours()  - from.getHours();
        return 100;
    }
}

//
//    private ParkingTicket bookParkingSpot(int id, String vehicleNo) {
//
//    }

// Single Floor
// Three Types of Parking Spot Large/Compact/Small
// Single Entry Single Exit
// Ticket System
// Payment systems

// select * from ParkingSpot where VehicleType = vehicleType AND isFree = true ORDER By distance ASC LIMIT 1;

class Account{ }

public class ParkingLot {
    List<Floor> floorList;
}

enum VehicleType {
    Large, Compact, Small
}

class Floor {
    List<ParkingSpot> parkingSpotList;
}

class ParkingSpot {
    int id;
    VehicleType type;
    boolean isFree;

    double distance;

    // metadata about floor
}

class ParkingTicket {
    int id;
    String vehicleNo;
    int parkingSpotId; // foreign key
    Date to, from;

    public ParkingTicket() {
    }

    public ParkingTicket(String vehicleNo, int parkingSpotId, Date to, Date from) {
        this.vehicleNo = vehicleNo;
        this.parkingSpotId = parkingSpotId;
        this.to = to;
        this.from = from;
    }
}
