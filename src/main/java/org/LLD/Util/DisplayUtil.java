package org.LLD.Util;

import org.LLD.Constants.Enums.VehicleType;

import java.util.List;
import java.util.Map;

public class DisplayUtil {
    FindingUtil findingUtil = new FindingUtil();
    public void displayFreeCount(Map<Integer,List<Integer>> result, VehicleType vehicleType) {
        if(result!=null) {
            for (Map.Entry<Integer, List<Integer>> resultEntry : result.entrySet()) {
                System.out.println("No. of free slots for " + vehicleType + " on Floor " + resultEntry.getKey() + ": " + resultEntry.getValue().size());
            }
        }
        else System.out.println("No Slots Are Free For Vehicle Type: "+vehicleType);
    }

    public void displayFreeSlots(Map<Integer,List<Integer>> result, VehicleType vehicleType) {
        if(result!=null) {
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
        if(result!=null) {
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
}
