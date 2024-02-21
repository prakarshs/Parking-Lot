package org.LLD.Services;

import org.LLD.Constants.Enums.VehicleType;

public interface ParkingService {

    String createParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSpots);

    void displayFreeCount(VehicleType vehicleType);
    void displayFreeSlots(VehicleType vehicleType);
    void displayOccupiedSlots(VehicleType vehicleType);

    String  parkVehicle(VehicleType vehicleType, String vehicleRegNumber, String vehicleColor);

    void displayTicket(Integer ticketId);
}
