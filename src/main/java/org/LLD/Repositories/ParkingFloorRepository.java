package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entities.ParkingFloor;
import org.LLD.Entities.ParkingLot;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap = new HashMap<>();
}
