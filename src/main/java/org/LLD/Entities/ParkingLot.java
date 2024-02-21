package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingLot {
    private String parkingLotId;
    private Map<Integer,ParkingFloor> parkingFloors;
}
