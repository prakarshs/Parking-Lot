package org.LLD.Util;

import org.LLD.Constants.Enums.SpotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSpot;
import org.LLD.Entities.ParkingTicket;
import org.LLD.Entities.VehicleEntity;
import org.LLD.Repositories.ParkingSpotRepository;
import org.LLD.Repositories.ParkingTicketRepository;

import java.util.*;

public class FindingUtil {
    public Map<Integer, List<Integer>> getFreeCountResult(VehicleType vehicleType, ParkingSpotRepository parkingLotRepository) {
        var vehicleTotalSlots = parkingLotRepository.getParkingSpotMap().get(vehicleType);
        if(!vehicleTotalSlots.isEmpty()) {
            Map<Integer, List<Integer>> result = new HashMap<>();

            for (Map.Entry<Integer, ParkingSpot> spotEntry : vehicleTotalSlots.entrySet()) {
                Integer floorId = spotEntry.getValue().getParkingFloorId();
                if (spotEntry.getValue().getSpotState() == SpotState.free) {
                    if (!result.containsKey(floorId)) {
                        result.put(floorId, new ArrayList<>());
                    }
                    result.get(floorId).add(spotEntry.getValue().getSpotId());
                }
            }
            return result;
        }
        else return null;

    }

    public Map<Integer, List<Integer>> getFreeSlotsResult(VehicleType vehicleType, ParkingSpotRepository parkingSpotRepository) {

        var vehicleTotalSlots = parkingSpotRepository.getParkingSpotMap().get(vehicleType);
        if(!vehicleTotalSlots.isEmpty()) {
            Map<Integer, List<Integer>> result = new HashMap<>();

            for (Map.Entry<Integer, ParkingSpot> spotEntry : vehicleTotalSlots.entrySet()) {
                Integer floorId = spotEntry.getValue().getParkingFloorId();
                if (spotEntry.getValue().getSpotState() == SpotState.free) {
                    if (!result.containsKey(floorId)) {
                        result.put(floorId, new ArrayList<>());
                    }
                    result.get(floorId).add(spotEntry.getValue().getSpotId());
                }
            }

            return result;
        }
        else return null;
    }

    public Map<Integer, List<Integer>> getOccupiedSlotsResult(VehicleType vehicleType, ParkingSpotRepository parkingSpotRepository) {

        var vehicleTotalSlots = parkingSpotRepository.getParkingSpotMap().get(vehicleType);
        if(!vehicleTotalSlots.isEmpty()) {
            Map<Integer, List<Integer>> result = new HashMap<>();
            for (Map.Entry<Integer, ParkingSpot> spotEntry : vehicleTotalSlots.entrySet()) {

                Integer floorId = spotEntry.getValue().getParkingFloorId();
                if (spotEntry.getValue().getSpotState() == SpotState.occupied) {
                    if (!result.containsKey(floorId)) {
                        result.put(floorId, new ArrayList<>());
                    }
                    result.get(floorId).add(spotEntry.getValue().getSpotId());
                }
            }
            return result;
        }
        else return null;
    }
    public ParkingSpot getSlotVehicle(VehicleType vehicleType, ParkingSpotRepository parkingSpotRepository) {
        var vehicleTotalSlots = parkingSpotRepository.getParkingSpotMap().get(vehicleType);
        if(!vehicleTotalSlots.isEmpty()){
            boolean found = false;
            for (Map.Entry<Integer, ParkingSpot> spotEntry : vehicleTotalSlots.entrySet()){
                if(spotEntry.getValue().getSpotState() == SpotState.free){
                    found = true;
                    return spotEntry.getValue();
                }
            }
            if(!found){
                System.out.println("No Empty Slots For Vehicle Type: "+vehicleType);
            }
        }
        else {
            System.out.println("!----- INVALID VEHICLE TYPE -----!");
            return null;
        }
        return null;
    }

    public ParkingTicket getTicket(Integer ticketId, ParkingTicketRepository parkingTicketRepository) {
        return parkingTicketRepository.getParkingTicketMap().get(ticketId);
    }
}
