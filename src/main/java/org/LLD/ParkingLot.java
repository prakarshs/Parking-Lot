package org.LLD;

import org.LLD.Services.Parking.ParkingService;
import org.LLD.Services.Parking.ParkingServiceIMPL;
import org.LLD.Constants.Commands;

import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {

        ParkingService parkingService = new ParkingServiceIMPL();

        Scanner scanner = new Scanner(System.in);

        while (true){
            String[] input = scanner.nextLine().trim().split(" ");

            switch (input[0]){

                case Commands.CREATE_PARKING_LOT : {
                    System.out.println(parkingService.createParkingLot(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3])));

                }
                break;
                case Commands.PARK_VEHICLE : {
                    System.out.println("park");

                }
                break;
                case Commands.UNPARK_VEHICLE : {
                    System.out.println("unpark");

                }
                break;
                case Commands.DISPLAY : {
                    System.out.println("disp");

                }
                break;
                case Commands.EXIT : {
                    System.out.println("exit");
                }
                break;
                default:{
                    System.out.println("default");

                }

            }
        }

    }
}