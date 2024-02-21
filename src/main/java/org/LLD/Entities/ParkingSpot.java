package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.SpotState;
import org.LLD.Constants.Enums.VehicleType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpot {
    private Integer spotId;
    private Integer parkingFloorId;
    private String parkingLotId;
    private VehicleType spotType;
    private SpotState spotState;

}
