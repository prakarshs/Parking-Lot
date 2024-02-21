package org.LLD.Util;

import org.LLD.Constants.Enums.SpotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSpot;
import org.LLD.Repositories.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindingUtil {
    public Map<Integer, List<Integer>> getFreeCountResult(VehicleType vehicleType, ParkingSpotRepository parkingLotRepository) {

        var vehicleSpotsTotal = parkingLotRepository.getParkingSpotMap().get(vehicleType);

        Map<Integer, List<Integer>> result = new HashMap<>();

        for(Map.Entry<Integer, ParkingSpot> spotEntry : vehicleSpotsTotal.entrySet()){

            Integer floorId = spotEntry.getValue().getParkingFloorId();
            if(spotEntry.getValue().getSpotState() == SpotState.free){
                if(!result.containsKey(floorId)) {
                    result.put(floorId, new ArrayList<>());
                }
                result.get(floorId).add(spotEntry.getValue().getSpotId());
            }
        }
        return result;

    }

    public Map<Integer, List<Integer>> getFreeSlotsResult(VehicleType vehicleType, ParkingSpotRepository parkingSpotRepository) {
        var vehicleTotalSlots = parkingSpotRepository.getParkingSpotMap().get(vehicleType);

        Map<Integer,List<Integer>> result = new HashMap<>();

        for (Map.Entry<Integer,ParkingSpot> spotEntry : vehicleTotalSlots.entrySet()){
            Integer floorId = spotEntry.getValue().getParkingFloorId();
            if(spotEntry.getValue().getSpotState() == SpotState.free){
                if(!result.containsKey(floorId)) {
                    result.put(floorId, new ArrayList<>());
                }
                result.get(floorId).add(spotEntry.getValue().getSpotId());
            }
        }

        return result;
    }
}
