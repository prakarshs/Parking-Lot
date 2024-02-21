package org.LLD.Util;

import org.LLD.Constants.Enums.SpotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSpot;
import org.LLD.Repositories.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayUtil {
    public void getFreeCount(VehicleType vehicleType, ParkingSpotRepository parkingLotRepository) {
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

       for (Map.Entry<Integer,List<Integer>> resultEntry : result.entrySet()){
           System.out.println("No. of free slots for "+vehicleType+" on Floor "+resultEntry.getKey()+": "+ resultEntry.getValue().size());
       }
    }

    public void getFreeSlots(VehicleType vehicleType, ParkingSpotRepository parkingSpotRepository) {
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

        for (Map.Entry<Integer,List<Integer>> resultEntry : result.entrySet()){
            System.out.print("Free slots for "+vehicleType+" on Floor "+resultEntry.getKey()+": ");
            resultEntry.getValue().forEach(spotId ->{
                System.out.print(spotId+",");
            });
            System.out.println();

        }

    }
}
