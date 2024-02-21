package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingTicket {
    private String parkingTicketId;
    private Date timeIssued;
    private VehicleEntity vehicleEntity;
}
