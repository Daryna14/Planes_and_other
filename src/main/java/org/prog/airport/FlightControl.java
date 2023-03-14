package org.prog.airport;

public class FlightControl {

   public Plane[] planes;

    public String[] passengerNames = new String[8];
   public int[] passengerSits = new int[8];
    public String[] passengerFlights = new String[8];
   public String[] destinations;

   public FlightControl(Plane[] airportPlanes){
       planes = airportPlanes;
       destinations = new String[] {"Italy, Greece"};
   }
   public void setPlaneDestination(String flightID, String destination) {
       Plane plane = getPlaneByFlightId(flightID);
       plane.setFlightDestination(destination);

   }
   public void boardPassenger(int passengerId) {
       String passengerName = passengerNames[passengerId];
       int passengerSit = passengerSits[passengerId];
       String flightID = passengerFlights[passengerId];

        Plane plane = getPlaneByFlightId(flightID);
        plane.boardPassenger(passengerName,passengerSit);
   }

   public Plane getPlaneByFlightId(String flightID){
       for (int i = 0; i < planes.length; i++) {
           if (planes[i].flightID.equals(flightID)){
               return planes[i];
           }
       }
        return null;
   }

   public void registerPassenger(int passengerId, String passengerName, int passengerSit, String flightID){
       passengerNames[passengerId] = passengerName;
       passengerSits[passengerId] = passengerSit;
       passengerFlights[passengerId] = flightID;
   }
}
