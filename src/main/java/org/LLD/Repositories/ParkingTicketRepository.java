package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entities.ParkingLot;
import org.LLD.Entities.ParkingTicket;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingTicketRepository {
    private Map<String, ParkingTicket> parkingTicketMap = new HashMap<>();
}
