package org.LLD.Helper;

import lombok.Data;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingLot;
import org.LLD.Entities.ParkingSpot;
import org.LLD.Repositories.ParkingFloorRepository;
import org.LLD.Repositories.ParkingLotRepository;
import org.LLD.Repositories.ParkingSpotRepository;
import org.LLD.Repositories.ParkingTicketRepository;

import java.util.HashMap;
import java.util.Map;
@Data
public class RepositoryAutowire {
    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
    ParkingTicketRepository parkingTicketRepository = new ParkingTicketRepository();
    Map<VehicleType, Map<Integer, ParkingSpot>> parkingSpotDefault = new HashMap<>();
    ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository(parkingSpotDefault);

}
