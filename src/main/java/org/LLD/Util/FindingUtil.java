package org.LLD.Util;

import org.LLD.Constants.Enums.SpotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSpot;
import org.LLD.Repositories.ParkingSpotRepository;

import java.util.*;

public class FindingUtil {
    public Map<Integer, List<Integer>> getFreeCountResult(VehicleType vehicleType, ParkingSpotRepository parkingLotRepository) {
        System.out.println("hi");
        var vehicleSpotsTotal = parkingLotRepository.getParkingSpotMap().get(vehicleType);

        System.out.println("hello");
        Map<Integer, List<Integer>> result = new HashMap<>();

        for (Map.Entry<Integer, ParkingSpot> spotEntry : vehicleSpotsTotal.entrySet()) {

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

    public Map<Integer, List<Integer>> getFreeSlotsResult(VehicleType vehicleType, ParkingSpotRepository parkingSpotRepository) {

        var vehicleTotalSlots = parkingSpotRepository.getParkingSpotMap().get(vehicleType);
        if(vehicleTotalSlots!=null) {
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
        if(vehicleTotalSlots!=null) {
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
}
