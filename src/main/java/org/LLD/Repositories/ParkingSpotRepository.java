package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingLot;
import org.LLD.Entities.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Builder
public class ParkingSpotRepository {
    private Map<VehicleType, Map<Integer, ParkingSpot>> parkingSpotMap = new HashMap<>();


    public ParkingSpotRepository(Map<VehicleType, Map<Integer, ParkingSpot>> parkingSpotMap){
        for(VehicleType vehicleType : VehicleType.values()){
            parkingSpotMap.put(vehicleType,new HashMap<>());
        }

        this.parkingSpotMap=parkingSpotMap;
    }
}
