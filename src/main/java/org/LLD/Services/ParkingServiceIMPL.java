package org.LLD.Services;

import org.LLD.Constants.Enums.SpotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.*;
import org.LLD.Helper.RepositoryAutowire;
import org.LLD.Helper.UtilAutowire;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingServiceIMPL implements ParkingService {

    UtilAutowire utilAutowire = new UtilAutowire();
    RepositoryAutowire repositoryAutowire = new RepositoryAutowire();

    @Override
    public String createParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSpots) {

        int spotIndex = 1;
        for (int floor = 1; floor <= numberOfFloors; floor++) {

            Map<Integer, ParkingSpot> spotsInFloor = new HashMap<>();
            for (int spot = 1; spot <= numberOfSpots; spot++) {

                ParkingSpot parkingSpot = ParkingSpot.builder().spotId(spot).parkingFloorId(floor).parkingLotId(parkingLotId).spotState(SpotState.free).spotType(VehicleType.CAR).build();

                if (spot == 1) {
                    parkingSpot.setSpotType(VehicleType.TRUCK);
                } else if (spot == 2 || spot == 3) {
                    parkingSpot.setSpotType(VehicleType.BIKE);
                }

                repositoryAutowire.getParkingSpotRepository().getParkingSpotMap().get(parkingSpot.getSpotType()).put(spotIndex, parkingSpot);
                spotIndex++;
                spotsInFloor.put(spot, parkingSpot);
            }

            ParkingFloor parkingFloor = ParkingFloor.builder().parkingFloorId(floor).parkingLotId(parkingLotId).parkingSpots(spotsInFloor).build();
            repositoryAutowire.getParkingFloorRepository().getParkingFloorMap().put(floor, parkingFloor);
        }


        ParkingLot parkingLot = ParkingLot.builder().parkingLotId(parkingLotId).parkingFloors(repositoryAutowire.getParkingFloorRepository().getParkingFloorMap()).build();

        return "Created parking lot with " + repositoryAutowire.getParkingFloorRepository().getParkingFloorMap().size() + " floors and " + repositoryAutowire.getParkingFloorRepository().getParkingFloorMap().get(2).getParkingSpots().size() + " slots per floor";
    }

    @Override
    public void displayFreeCount(VehicleType vehicleType) {
        Map<Integer, List<Integer>> result = utilAutowire.getFindingUtil().getFreeCountResult(vehicleType, repositoryAutowire.getParkingSpotRepository());
        utilAutowire.getDisplayUtil().displayFreeCount(result, vehicleType);
    }

    @Override
    public void displayFreeSlots(VehicleType vehicleType) {
        Map<Integer, List<Integer>> result = utilAutowire.getFindingUtil().getFreeSlotsResult(vehicleType, repositoryAutowire.getParkingSpotRepository());
        utilAutowire.getDisplayUtil().displayFreeSlots(result, vehicleType);

    }

    @Override
    public void displayOccupiedSlots(VehicleType vehicleType) {
        Map<Integer, List<Integer>> result = utilAutowire.getFindingUtil().getOccupiedSlotsResult(vehicleType, repositoryAutowire.getParkingSpotRepository());
        utilAutowire.getDisplayUtil().displayOccupiedSlots(result, vehicleType);

    }

    @Override
    public String parkVehicle(VehicleType vehicleType, String vehicleRegNumber, String vehicleColor) {

        VehicleEntity vehicle = VehicleEntity.builder().vehicleType(vehicleType).vehicleRegNumber(vehicleRegNumber).vehicleColor(vehicleColor).build();

        ParkingSpot spot = utilAutowire.getFindingUtil().getSlotVehicle(vehicle.getVehicleType(), repositoryAutowire.getParkingSpotRepository());

        String res = "Could Not Park Vehicle.";
        if (spot != null) {
            ParkingTicket ticket = utilAutowire.getTicketUtil().generateTicket(spot, vehicle, repositoryAutowire.getParkingTicketRepository());
            spot.setSpotState(SpotState.occupied);
            res = "Parked vehicle. Ticket ID: " + ticket.getParkingTicketId();
        }
        return res;
    }

    @Override
    public void displayTicket(String ticketId) {
        ParkingTicket ticket = utilAutowire.getFindingUtil().getTicket(ticketId, repositoryAutowire.getParkingTicketRepository());
        utilAutowire.getDisplayUtil().displayTicketDetails(ticket);
    }

    @Override
    public String unparkVehicle(String ticketCode) {

        ParkingTicket ticket = utilAutowire.getFindingUtil().getTicket(ticketCode, repositoryAutowire.getParkingTicketRepository());

        ParkingSpot spot = ticket.getParkingSpot();

        String unparkResponse = "!----- Invalid Ticket -----!";

        if (ticket != null && spot.getSpotState() == SpotState.occupied) {
            spot.setSpotState(SpotState.free);
            unparkResponse = "Unparked vehicle with Registration Number: " + ticket.getVehicleEntity().getVehicleRegNumber() + " and Color: " + ticket.getVehicleEntity().getVehicleColor();
        }
        return unparkResponse;
    }
}
