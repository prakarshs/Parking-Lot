package org.LLD.Util;

import org.LLD.Entities.ParkingSpot;
import org.LLD.Entities.ParkingTicket;
import org.LLD.Entities.VehicleEntity;
import org.LLD.Repositories.ParkingTicketRepository;

import java.time.Instant;
import java.util.Date;

public class TicketUtil {
    public ParkingTicket generateTicket(ParkingSpot spot, VehicleEntity vehicle, ParkingTicketRepository parkingTicketRepository) {
        ParkingTicket ticket = ParkingTicket.builder()
                .parkingTicketId(spot.getParkingLotId()+"_"+spot.getParkingFloorId()+"_"+spot.getSpotId())
                .vehicleEntity(vehicle)
                .timeIssued(Date.from(Instant.now()))
                .parkingSpot(spot)
                .build();

        parkingTicketRepository.getParkingTicketMap().put(ticket.getParkingTicketId(), ticket);
        return ticket;
    }
}
