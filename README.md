# Parking Lot

![Parking Lot](https://images.unsplash.com/photo-1604063155785-ee4488b8ad15?q=80&w=2069&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D)

Design the next generation parking lot system which can manage a parking lot without any human intervention.

## Requirements
Create a command-line application for the parking lot system with the following requirements:
* The functions that the parking lot system can do:
  * Create the parking lot.
  * Add floors to the parking lot. 
  * Add a parking lot slot to any of the floors.
  * Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
  * Unparks a vehicle given the ticket id
  * Displays the number of free slots per floor for a specific vehicle type. 
  * Displays all the free slots per floor for a specific vehicle type. 
  * Displays all the occupied slots per floor for a specific vehicle type.


* Details about the Vehicles:
  * Every vehicle will have a type, registration number, and color.
  * Different Types of Vehicles:
    * Car
    * Bike
    * Truck


* Details about the Parking Slots:
  * Each type of slot can park a specific type of vehicle.
  * No other vehicle should be allowed by the system.
  * Finding the first available slot should be based on:
    * The slot should be of the same type as the vehicle.
    * The slot should be on the lowest possible floor in the parking lot.
    * The slot should have the lowest possible slot number on the floor.
  * Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.


* Details about the Parking Lot Floors:
  * Numbered serially from 1 to n where n is the number of floors.
  * Might contain one or more parking lot slots of different types.
  * We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.


* Details about the Tickets:
  * The ticket id would be of the following format:


    <parking_lot_id>_<floor_no>_<slot_no>
    Example: PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
* We can assume that there will only be 1 parking lot. The ID of that parking lot is PR1234.


### Sample Input
````
create_parking_lot PR1234 2 6
display free_count CAR
display free_count BIKE
display free_count TRUCK
display free_slots CAR
display free_slots BIKE
display free_slots TRUCK
display occupied_slots CAR
display occupied_slots BIKE
display occupied_slots TRUCK
park_vehicle CAR KA-01-DB-1234 black
park_vehicle CAR KA-02-CB-1334 red
park_vehicle CAR KA-01-DB-1133 black
park_vehicle CAR KA-05-HJ-8432 white
park_vehicle CAR WB-45-HO-9032 white
park_vehicle CAR KA-01-DF-8230 black
park_vehicle CAR KA-21-HS-2347 red
display free_count CAR
display free_count BIKE
display free_count TRUCK
unpark_vehicle PR1234_2_5
unpark_vehicle PR1234_2_5
unpark_vehicle PR1234_2_7
display free_count CAR
display free_count BIKE
display free_count TRUCK
display free_slots CAR
display free_slots BIKE
display free_slots TRUCK
display occupied_slots CAR
display occupied_slots BIKE
display occupied_slots TRUCK
park_vehicle BIKE KA-01-DB-1541 black
park_vehicle TRUCK KA-32-SJ-5389 orange
park_vehicle TRUCK KL-54-DN-4582 green
park_vehicle TRUCK KL-12-HF-4542 green
display free_count CAR
display free_count BIKE
display free_count TRUCK
display free_slots CAR
display free_slots BIKE
display free_slots TRUCK
display occupied_slots CAR
display occupied_slots BIKE
display occupied_slots TRUCK
exit
````
### Sample Output
````
Created parking lot with 2 floors and 6 slots per floor
No. of free slots for CAR on Floor 1: 3
No. of free slots for CAR on Floor 2: 3
No. of free slots for BIKE on Floor 1: 2
No. of free slots for BIKE on Floor 2: 2
No. of free slots for TRUCK on Floor 1: 1
No. of free slots for TRUCK on Floor 2: 1
Free slots for CAR on Floor 1: 4,5,6
Free slots for CAR on Floor 2: 4,5,6
Free slots for BIKE on Floor 1: 2,3
Free slots for BIKE on Floor 2: 2,3
Free slots for TRUCK on Floor 1: 1
Free slots for TRUCK on Floor 2: 1
Occupied slots for CAR on Floor 1:
Occupied slots for CAR on Floor 2:
Occupied slots for BIKE on Floor 1:
Occupied slots for BIKE on Floor 2:
Occupied slots for TRUCK on Floor 1:
Occupied slots for TRUCK on Floor 2:
Parked vehicle. Ticket ID: PR1234_1_4
Parked vehicle. Ticket ID: PR1234_1_5
Parked vehicle. Ticket ID: PR1234_1_6
Parked vehicle. Ticket ID: PR1234_2_4
Parked vehicle. Ticket ID: PR1234_2_5
Parked vehicle. Ticket ID: PR1234_2_6
Parking Lot Full
No. of free slots for CAR on Floor 1: 0
No. of free slots for CAR on Floor 2: 0
No. of free slots for BIKE on Floor 1: 2
No. of free slots for BIKE on Floor 2: 2
No. of free slots for TRUCK on Floor 1: 1
No. of free slots for TRUCK on Floor 2: 1
Unparked vehicle with Registration Number: WB-45-HO-9032 and Color: white
Invalid Ticket
Invalid Ticket
No. of free slots for CAR on Floor 1: 0
No. of free slots for CAR on Floor 2: 1
No. of free slots for BIKE on Floor 1: 2
No. of free slots for BIKE on Floor 2: 2
No. of free slots for TRUCK on Floor 1: 1
No. of free slots for TRUCK on Floor 2: 1
Free slots for CAR on Floor 1:
Free slots for CAR on Floor 2: 5
Free slots for BIKE on Floor 1: 2,3
Free slots for BIKE on Floor 2: 2,3
Free slots for TRUCK on Floor 1: 1
Free slots for TRUCK on Floor 2: 1
Occupied slots for CAR on Floor 1: 4,5,6
Occupied slots for CAR on Floor 2: 4,6
Occupied slots for BIKE on Floor 1:
Occupied slots for BIKE on Floor 2:
Occupied slots for TRUCK on Floor 1:
Occupied slots for TRUCK on Floor 2:
Parked vehicle. Ticket ID: PR1234_1_2
Parked vehicle. Ticket ID: PR1234_1_1
Parked vehicle. Ticket ID: PR1234_2_1
Parking Lot Full
No. of free slots for CAR on Floor 1: 0
No. of free slots for CAR on Floor 2: 1
No. of free slots for BIKE on Floor 1: 1
No. of free slots for BIKE on Floor 2: 2
No. of free slots for TRUCK on Floor 1: 0
No. of free slots for TRUCK on Floor 2: 0
Free slots for CAR on Floor 1:
Free slots for CAR on Floor 2: 5
Free slots for BIKE on Floor 1: 3
Free slots for BIKE on Floor 2: 2,3
Free slots for TRUCK on Floor 1:
Free slots for TRUCK on Floor 2:
Occupied slots for CAR on Floor 1: 4,5,6
Occupied slots for CAR on Floor 2: 4,6
Occupied slots for BIKE on Floor 1: 2
Occupied slots for BIKE on Floor 2:
Occupied slots for TRUCK on Floor 1: 1
Occupied slots for TRUCK on Floor 2: 1
````