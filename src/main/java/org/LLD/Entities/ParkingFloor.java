package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.VehicleType;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingFloor {
    private String parkingLotId;
    private Integer parkingFloorId;
    private Map<Integer,ParkingSpot> parkingSpots;

}
