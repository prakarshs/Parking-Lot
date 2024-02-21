package org.LLD.Services.Parking;

import org.LLD.Constants.Enums.SpotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingFloor;
import org.LLD.Entities.ParkingLot;
import org.LLD.Entities.ParkingSpot;
import org.LLD.Helper.RepositoryAutowire;

import java.util.HashMap;
import java.util.Map;

public class ParkingServiceIMPL implements ParkingService{

    RepositoryAutowire repositoryAutowire = new RepositoryAutowire();
    @Override
    public String createParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSpots) {

        int spotIndex = 1;
        for (int floor = 1; floor <= numberOfFloors; floor++){

            Map<Integer,ParkingSpot> spotsInFloor = new HashMap<>();
            for (int spot = 1; spot <= numberOfSpots; spot++){

                ParkingSpot parkingSpot = ParkingSpot.builder()
                        .parkingLotId(floor+"_"+spot)
                        .parkingFloorId(floor)
                        .parkingLotId(parkingLotId)
                        .spotState(SpotState.free)
                        .spotType(VehicleType.CAR)
                        .build();

                if(spot == 1){
                    parkingSpot.setSpotType(VehicleType.TRUCK);
                } else if (spot ==2 || spot==3) {
                    parkingSpot.setSpotType(VehicleType.BIKE);
                }

                repositoryAutowire.getParkingSpotRepository().getParkingSpotMap().get(parkingSpot.getSpotType()).put(spotIndex,parkingSpot);
                spotIndex++;
                spotsInFloor.put(spot,parkingSpot);
            }

            ParkingFloor parkingFloor = ParkingFloor.builder()
                    .parkingFloorId(floor)
                    .parkingLotId(parkingLotId)
                    .parkingSpots(spotsInFloor)
                    .build();
            repositoryAutowire.getParkingFloorRepository().getParkingFloorMap().put(floor,parkingFloor);
        }


        ParkingLot parkingLot = ParkingLot.builder()
                .parkingLotId(parkingLotId)
                .parkingFloors(repositoryAutowire.getParkingFloorRepository().getParkingFloorMap())
                .build();

        return "Created parking lot with "+repositoryAutowire.getParkingFloorRepository().getParkingFloorMap().size()+" floors and "+repositoryAutowire.getParkingFloorRepository().getParkingFloorMap().get(2).getParkingSpots().size()+" slots per floor";
    }
}
