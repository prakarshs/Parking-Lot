package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.VehicleType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleEntity {
    private String vehicleRegNumber;
    private String vehicleColor;
    private VehicleType vehicleType;
}
