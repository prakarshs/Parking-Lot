package org.LLD.Services;

import org.LLD.Constants.Enums.VehicleType;

public interface ParkingService {

    String createParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSpots);

    String displayFreeCount(VehicleType vehicleType);
    String displayFreeSlots(VehicleType vehicleType);
    String displayOccupiedSlots(VehicleType vehicleType);
}
