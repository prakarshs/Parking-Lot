package org.LLD;

import org.LLD.Constants.Enums.DisplayFilter;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Services.ParkingService;
import org.LLD.Services.ParkingServiceIMPL;
import org.LLD.Constants.Commands;

import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {

        ParkingService parkingService = new ParkingServiceIMPL();

        Scanner scanner = new Scanner(System.in);
        boolean program = true;
        while (program){
            String[] input = scanner.nextLine().trim().split(" ");

            switch (input[0]){

                case Commands.CREATE_PARKING_LOT : {
                    System.out.println(parkingService.createParkingLot(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3])));

                }
                break;
                case Commands.PARK_VEHICLE : {
                    System.out.println(parkingService.parkVehicle(VehicleType.valueOf(input[1]),input[2], input[3]));

                }
                break;
                case Commands.UNPARK_VEHICLE : {
                    System.out.println("unpark");

                }
                break;
                case Commands.DISPLAY : {
                    if(input[1].equals(String.valueOf(DisplayFilter.free_count))){
                       parkingService.displayFreeCount(VehicleType.valueOf(input[2]));
                    } else if (input[1].equals(String.valueOf(DisplayFilter.free_slots))) {
                        parkingService.displayFreeSlots(VehicleType.valueOf(input[2]));
                    } else if (input[1].equals(String.valueOf(DisplayFilter.occupied_slots))) {
                        parkingService.displayOccupiedSlots(VehicleType.valueOf(input[2]));
                    } else System.out.println("!----- INVALID DISPLAY FILTER -----!");
                }
                break;
                case Commands.EXIT : {
                    program=false;
                }
                break;
                default:{
                    System.out.println("default");

                }

            }
        }
        System.out.println("***** THANK YOU FOR USING OUR PARKING LOT *****");

    }
}