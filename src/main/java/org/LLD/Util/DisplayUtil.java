package org.LLD.Util;

import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingTicket;
import org.LLD.Repositories.ParkingTicketRepository;

import java.util.List;
import java.util.Map;

public class DisplayUtil {
    FindingUtil findingUtil = new FindingUtil();
    public void displayFreeCount(Map<Integer,List<Integer>> result, VehicleType vehicleType) {
        if(!result.isEmpty()) {
            for (Map.Entry<Integer, List<Integer>> resultEntry : result.entrySet()) {
                System.out.println("No. of free slots for " + vehicleType + " on Floor " + resultEntry.getKey() + ": " + resultEntry.getValue().size());
            }
        }
        else System.out.println("No Slots Are Free For Vehicle Type: "+vehicleType);
    }

    public void displayFreeSlots(Map<Integer,List<Integer>> result, VehicleType vehicleType) {
        if(!result.isEmpty()) {
            for (Map.Entry<Integer, List<Integer>> resultEntry : result.entrySet()) {
                System.out.print("Free slots for " + vehicleType + " on Floor " + resultEntry.getKey() + ": ");
                resultEntry.getValue().forEach(spotId -> {
                    System.out.print(spotId + ",");
                });
                System.out.println();

            }
        }
        else System.out.println("No Slots Are Free For Vehicle Type: "+vehicleType);

    }

    public void displayOccupiedSlots(Map<Integer, List<Integer>> result, VehicleType vehicleType) {
        if(!result.isEmpty()) {
            for (Map.Entry<Integer, List<Integer>> resultEntry : result.entrySet()) {
                System.out.print("Occupied slots for " + vehicleType + " on Floor " + resultEntry.getKey() + ": ");
                resultEntry.getValue().forEach(spotId -> {
                    System.out.print(spotId + ",");
                });
                System.out.println();
            }
        }
        else System.out.println("No Slots Are Occupied For Vehicle Type: "+vehicleType);
    }

    public void displayTicketDetails(ParkingTicket ticket) {
        if (ticket!=null){
            System.out.println("Ticket Reg Number: "+ticket.getParkingTicketId() + "\n"
            + "Slot Id: "+ticket.getParkingSpot().getParkingFloorId()+"_"+ticket.getParkingSpot().getSpotId()+ "\n"
            + "Vehicle Details: "+ticket.getVehicleEntity().getVehicleType()+","+ticket.getVehicleEntity().getVehicleRegNumber()+","+ticket.getVehicleEntity().getVehicleColor() + "\n"
            );
        }
        else System.out.println("!----- Invalid Ticket Id -----!");

    }
}
